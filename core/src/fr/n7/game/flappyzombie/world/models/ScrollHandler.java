package fr.n7.game.flappyzombie.world.models;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

import fr.n7.game.flappyzombie.world.models.base.Game2DEntityGroup;

/**
 * Created by Nementon on 06/04/2015.
 */
public class ScrollHandler extends Game2DEntityGroup {

    public static final int SCROLL_SPEED = -59;

    private List<Grass> _grass;
    private List<Pipe> _pipes;

    public ScrollHandler(float yPos) {
        _grass = new LinkedList<Grass>();
        _pipes = new LinkedList<Pipe>();

        Grass frontGrass = new Grass(0, yPos, 143, 11, SCROLL_SPEED);
        Grass backGrass = new Grass(frontGrass.tailX(), yPos, 143, 11,
                SCROLL_SPEED);

        _grass.add(frontGrass);
        _grass.add(backGrass);

        Pipe pipe1 = new Pipe(210, 0, 22, 60, SCROLL_SPEED);
        Pipe pipe2 = new Pipe(pipe1.tailX() + Pipe.PIPE_GAP, 0, 22, 70, SCROLL_SPEED);
        Pipe pipe3 = new Pipe(pipe2.tailX() + Pipe.PIPE_GAP, 0, 22, 60, SCROLL_SPEED);

        _pipes.add(pipe1);
        _pipes.add(pipe2);
        _pipes.add(pipe3);
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        updateGrass();
        updatePipes();
    }

    private void updatePipes() {
        for (int i=0; i<3; ++i) {
            Pipe pipe = _pipes.get(i);

            if (pipe.isScrolledLeft()) {
                switch (i) {
                    case 0:
                        pipe.reset(_pipes.get(2).tailX() + Pipe.PIPE_GAP);
                        break;
                    case 1:
                        pipe.reset(_pipes.get(0).tailX() + Pipe.PIPE_GAP);
                        break;
                    case 2:
                        pipe.reset(_pipes.get(1).tailX() + Pipe.PIPE_GAP);
                        break;
                }
                break;
            }
        }
    }

    private void updateGrass() {
        for (int i = 0; i<2; ++i) {
            Grass grass = _grass.get(i);
            if (grass.isScrolledLeft()) {
                switch (i) {
                    case 0:
                        grass.reset(_grass.get(1).tailX());
                        break;
                    case 1:
                        grass.reset(_grass.get(0).tailX());
                        break;
                }
                break;
            }
        }
    }

    @Override
    public boolean add(IGame2DEntity entity) {
        return false;
    }

    @Override
    public boolean remove(IGame2DEntity entity) {
        return false;
    }

    @Override
    public List<IGame2DEntity> child() {
        return new CompositeUnmodifiableList<IGame2DEntity>(_grass, _pipes);
    }

    @Override
    public float x() {
        return 0;
    }

    @Override
    public float y() {
        return 0;
    }

    @Override
    public float width() {
        return 0;
    }

    @Override
    public float height() {
        return 0;
    }

    private class CompositeUnmodifiableList<E> extends AbstractList<E> {

        private final List<E> _list1;
        private final List<E> _list2;

        public CompositeUnmodifiableList(List<Grass> list1, List<Pipe> list2) {
            _list1 = (List<E>)list1;
            _list2 = (List<E>)list2;
        }

        @Override
        public E get(int index) {
            if (index < _list1.size()) {
                return _list1.get(index);
            }
            return _list2.get(index - _list1.size());
        }

        @Override
        public int size() {
            return _list1.size() + _list2.size();
        }
    }
}
