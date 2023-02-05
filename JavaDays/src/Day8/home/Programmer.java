package Day8.home;

public class Programmer extends Employee {

    protected Programmer(TaskProgressCallback callback,String name){
        super(callback,name, Task.Status.READY_TO_DO);
    }

    @Override
    protected Task getTaskWhenDone(Task task) {
        return new Task(
                task.getId(),
                Task.Status.READY_FOR_TEST,
                task.getDescription(),
                task.getDesignLink(),
                task.getTestcase(),
                getBuildLinkForTask(task.getId())
        );
    }

    private String getBuildLinkForTask(int id) {
        return "https://bitbucket/project/link_for_build_with_task_id "+id;
    }


    @Override
    protected String getDetails(Task task) {
        return " with task id"+task.getId()+
                " and designLink "+task.getDesignLink()+
                "\nand testcase "+task.getTestcase();
    }
}
