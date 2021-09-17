package be.upgrade.it.engineering.ideshortcuts.editor;

public class ThisWillNotCompile implements Logger{

    private static void logMessage(String message){
//        System.out.printnl(message)
    }

    public void doSomething(){
        log("calling doSomething");
    }

    @Override
    public void log(String message) {
//        logMassage(message);
    }

}
