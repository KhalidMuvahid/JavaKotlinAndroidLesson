package Day8.home;

public class Designer extends Employee {


    protected Designer(TaskProgressCallback callback,String name){
        super(callback,name, Task.Status.ASSEMBLING_REQUIREMENTS);
    }

    @Override
    protected Task getTaskWhenDone(Task task) {
        return new Task(
                task.getId(),
                Task.Status.READY_TO_DO,
                task.getDescription(),
                getDesignLinkForTask(task.getId()),
                getTestCaseForTask(task.getDescription()),
                ""
        );
    }

    private String getTestCaseForTask(String description) {
        return "when "+description+" get result "+Math.random();
    }

    private String getDesignLinkForTask(int id) {
        return "https://project/design_link_for_task_with_id "+id;

    }

    @Override
    protected String getDetails(Task task) {
        return " with taskId"+task.getId()+" and description "+task.getDescription();
    }
}
