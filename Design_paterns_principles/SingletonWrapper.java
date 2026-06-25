public class SingletonWrapper {
    public static void main(String[] args) {
        TaskManager primaryManager = TaskManager.getInstance();
        TaskManager secondaryManager = TaskManager.getInstance();
        
        primaryManager.log("App started");
        System.out.println(primaryManager == secondaryManager);
    }
}

class TaskManager {
    private static TaskManager activeInstance;

    private TaskManager() {
        System.out.println("Log created");
    }

    public static TaskManager getInstance() {
        if (activeInstance == null) {
            activeInstance = new TaskManager();
        }
        return activeInstance;
    }

    public void log(String text) {
        System.out.println(text);
    }
}
