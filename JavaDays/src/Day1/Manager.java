package Day1;

public class Manager {

    private static final String MANAGER = "Manager";
    public static void meeting(String name,int salary){
        Main.print(MANAGER,"Hello "+name+" you are welcome");
        if (salary > 500_000){
            Main.print(MANAGER,"we cant accept you you are asking to much we are sorry");
        }else {
            Main.print(MANAGER,"you are good but we have to check you knowledge.Follow me,i`ll show you interview room");
            Interviewer.checkKnows(name);
        }

    }
}
