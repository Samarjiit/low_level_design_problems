import logger.*;

public  class Main {
    public static  void main(String[] args){
        ILogger debugLogger=LoggerFactory.createLogger(LogLevel.DEBUG);
        ILogger errorLogger=LoggerFactory.createLogger(LogLevel.ERROR);
        ILogger infoLogger=LoggerFactory.createLogger(LogLevel.INFO);


        debugLogger.log("this is a dubug logger");
        errorLogger.log("this is a error logger");
        infoLogger.log("this is a info logger");
    }
}