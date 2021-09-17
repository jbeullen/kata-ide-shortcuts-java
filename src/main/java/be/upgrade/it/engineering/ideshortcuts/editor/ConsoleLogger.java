package be.upgrade.it.engineering.ideshortcuts.editor;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
