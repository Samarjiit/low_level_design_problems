package logger;
//A logger is a component in software applications used to record messages about the application's execution, mainly for debugging and monitoring purposes.
public class LoggerFactory {
    public static ILogger createLogger(LogLevel logLevel) {
        switch(logLevel) {
            case DEBUG:
                return new DebugLogger();
            case INFO:
                return new InfoLogger();
            case ERROR:
                return new ErrorLogger();
            default:
                return null;
        }
    }
}

//If createLogger were non-static, every time you need a logger, you’d have to instantiate LoggerFactory, wasting memory.