package Day8.home;

public class WorkerChain {

    private final Employee worker;
    private WorkerChain nextWorkerChain;

    public WorkerChain(Employee worker){
        this.worker = worker;
    }

    public void doTask(Task task){
        if (task.getStatus() == worker.getTaskStatus()){
            worker.doTask(task);
        } else if (nextWorkerChain != null) {
            nextWorkerChain.doTask(task);
        }else{
            throw new IllegalArgumentException("task can`t be handled");
        }
    }

    public void setNextWorkerChain(WorkerChain nextWorkerChain){
        this.nextWorkerChain = nextWorkerChain;
    }

}
