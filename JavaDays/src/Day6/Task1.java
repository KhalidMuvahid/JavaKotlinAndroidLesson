package Day6;
public class Task1 {
    public static void main(String[] args) {

    }
}

/*1. Написать класс Личности, в нем должны быть поля имени и фамилии как минимум,остальное на ваше усмотрение.*/
class Person{
    private String name;
    private String second_name;
    private String description;
    Person(String name,String second_name,String description){
        this.name = name;
        this.second_name = second_name;
        this.description = description;
    }
}

/*2.Написать класс для хранения некоего айди числового и строки с информацией*/
class Info{
    private int id;
    private String info;

    Info(int id,String info){
        this.id = id;
        this.info = info;
    }
}

/*3.Написать класс для урока. В нем должен быть номер урока и флаг – завершен или нет.*/
class Lesson{
    private int lesNum;
    private boolean finish;

    Lesson(int lesNum,boolean finish){
        this.lesNum = lesNum;
        this.finish=finish;
    }
}