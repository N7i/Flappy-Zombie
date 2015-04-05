package fr.n7.game.flappyzombie.fr.n7.game.flappyzombie.logger;

/**
 * Created by Nementon on 05/04/2015.
 */
public interface ILogger {
    void log (String tag, String message);

    /** Logs a message to the console or logcat */
    void log (String tag, String message, Throwable exception);

    void log(String message);

    void log(String message, Throwable exception);

    /** Logs an error message to the console or logcat */
    void error (String tag, String message);

    /** Logs an error message to the console or logcat */
    void error (String tag, String message, Throwable exception);

    void error(String message);

    void  error(String message, Throwable exception);

    /** Logs a debug message to the console or logcat */
    void debug (String tag, String message);

    /** Logs a debug message to the console or logcat */
    void debug (String tag, String message, Throwable exception);

    void debug(String message);

    void debug(String message, Throwable exception);

    /** Sets the log level. {@link #LOG_NONE} will mute all log output. {@link #LOG_ERROR} will only let error messages through.
     * {@link #LOG_INFO} will let all non-debug messages through, and {@link #LOG_DEBUG} will let all messages through.
     * @param logLevel {@link #LOG_NONE}, {@link #LOG_ERROR}, {@link #LOG_INFO}, {@link #LOG_DEBUG}.
    public void setLogLevel (int logLevel);

     Gets the log level.
    public int getLogLevel ();
    */
}
