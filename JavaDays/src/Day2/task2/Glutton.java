package Day2.task2;
public class Glutton {
    public static void main(String[] args) {
        int count =0;
        String person = "Jonny";
        String meal = "Potato";
        eat(person,meal);
        meal = "MeatBall";
        eat(person,meal);

    }

    private static void eat(String person, String meal) {
        System.out.println(person+" ate "+meal+" he is happy now");
    }
}
