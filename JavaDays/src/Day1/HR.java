package Day1;

public class HR {
    public static void check(String name,int salary,String skill){
        if (skill.toLowerCase().contains("junior")){
            Main.print("HR","We are sorry.But we can`t offer work for u"+name+"We looking for middle and senior dev.");
        }else{
            Main.print("HR","You are welcome "+name+" Manager will wait for you you tomorrow at 12am");
            Manager.meeting(name,salary);
        }
    }

}




