package Day8.home;

public abstract class Employee {

    private final TaskProgressCallback callback;
    private final String name;
    private final Task.Status taskStatus;

    protected Employee(TaskProgressCallback callback,
                       String name,
                       Task.Status status) {
        this.callback = callback;
        this.name = name;
        this.taskStatus = status;
    }

    public void doTask(Task task){
        System.out.println(getClass().getSimpleName() + " " +name+
                " is doing task "+getDetails(task));
        callback.updateTask(getTaskWhenDone(task));
    }

    public Task.Status getTaskStatus(){
        return taskStatus;
    }


    protected abstract Task getTaskWhenDone(Task task);
    protected abstract String getDetails(Task task);
}

