package Day8.home;
public class Solution {
    public static void main(String[] args) {
        TaskFactory factory = new TaskFactory();
        TaskProgressCallback callback = new TaskProgressCallback() {
            @Override
            public void updateTask(Task task) {
                factory.updateTask(task);
            }
        };

        WorkerChain chain = new WorkerChain(new Designer(callback,"Alicia"));
        WorkerChain next = new WorkerChain(new Programmer(callback,"Jhon"));
        WorkerChain last = new WorkerChain(new Tester(callback,"Steve"));
        next.setNextWorkerChain(last);
        chain.setNextWorkerChain(next);

        while (true){
            chain.doTask(factory.getTask());
        }


    }
}
