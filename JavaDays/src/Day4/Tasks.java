package Day4;



public class Tasks {
    private static int count=0;

    public static void main(String[] args) {
        method1(12, 11, 10);
        method2(12, 11, 10, 8);
        method3(false, false);
        method4(100, 60, 20);
        method5(10);
        method6(22);
        method7(" Anton ");
        method7("");
        method8();method8();method8();method8();method8();method8();
        method9(2);
        method11("sttr1","sttr1");



    }


    /*1. Метод получает 3 числа на вход и проверяет – существует ли такой треугольник или нет
        (он существует если сумма любых 2 сторон больше третьей)
    */
    static void method1(int a, int b, int c) {
        if ((a > 0 && b > 0 && c > 0) && ((a + b > c) && (b + c > a) && (c + a > b))) {
            System.out.println("Triangle exist");
        } else {
            System.out.println("Triangle not exist");
        }
    }

    //2. Метод получает 4 числа на вход и отображает самое меньшее из них
    static void method2(int a, int b, int c, int d) {
        System.out.println(min(min(a, b), min(c, d)));
    }

    static int min(int i, int k) {
        return i < k ? i : k;
    }


    /*3. Метод получает на вход параметр булеан типа – сегодня выходной или нет, и сегодня
    праздник или нет. И если нам надо на работу (в выходные и в праздники не надо) то у нас
    звонит будильник в 6 утра. Можете усложнить еще так – если просто выходной , то
    будильник на 11 утра. Но если праздник и выходной совпали, то не надо будильников как и в
    любой праздничный день.*/
    static void method3(boolean isWeekend, boolean isHoliday) {
        if (isHoliday) {
            System.out.println("no Alarm");
        } else if (isWeekend) {
            System.out.println("Alarm at 11");
        } else {
            System.out.println("alarm at 6");
        }
    }

    /*4. Метод получает на вход 3 числа – значения углов. Исходя из этого проверить его тип –
    равносторонний, прямоугольный, равнобедренный, тупоугольный, остроугольный.*/
    static void method4(int angle1, int angle2, int angle3) {

        if (angle1 != 0 && angle1 < 180 && angle2 != 0 && angle2 < 180 && angle3 != 0 && angle3 < 180) {
            if (angle1 == 90 || angle2 == 90 || angle3 == 90) {
                System.out.println("прямоугольный");
            }

            if (angle1 > 90 || angle2 > 90 || angle3 > 90) {
                System.out.println("тупоугольный");
            }

            if (angle1 == angle2 && angle2 == angle3) {
                System.out.println("равносторонний");
            }

            if ((angle1 == angle2 && angle1 != angle3) || (angle1 < angle3 && angle1 != angle2)) {
                System.out.println("равнобедренный");
            }
        } else {
            System.out.println("not valid data");
        }

    }


    /*5. Получаем на вход число – возраст человека. Если он старше 18, то даем доступ к контенту
    (просто вывести строку в консоль). Но если число неадекватное (сами придумайте проверку
    возрасту), то выводим – вы бот.*/
    static void method5(int age){
        if (age>18 && age<=100){
            System.out.println("You are take content");
        }else if (age<0 || age>100){
            System.out.println("You are bot");
        }else{
            System.out.println("you are to young for this content");
        }
    }

    /*6. Напишите метод, который исходя из входного параметра возраста определит куда ему идти
        сегодня утром (детсад, школа, колледж, универ, работа, поликлиника (пенсионеры)). Рамки
        для возраста придумайте сами. Если же входной параметр неадекватный – послать куда
        подальше.*/
    static void method6(int age){
        if (age<0 || age>100){
            System.out.println("You are bot");
        }else{
            if (age<6){
                System.out.println("детсад");
            }else if (age>6 && age<=18){
                System.out.println("школа");
            }else if (age>18 &&age<24){
                System.out.println("колледж, универ");
            }else if (age>24 && age<=60){
                System.out.println("работа");
            }else if (age>60){
                System.out.println("поликлиника");
            }
        }
    }

    /*7. Метод, который не любит Антонов и Денисов. Получаем входной аргумент, если это Антон
    или Денис, то выводим в консоль – добро пожаловать отсюда. Для всех други имен – добро
    пожаловать. Можете использовать константу для куска строки.*/
    static void method7(String name){
        final String ANTON = "anton";
        final String DENIS = "denis";
        String checkedName = name.trim().toLowerCase();
        if (!checkedName.isEmpty()){
            if (checkedName.contains(ANTON) || checkedName.contains(DENIS)){
                System.out.println("добро пожаловать отсюда");
            }else {
                System.out.println("добро пожаловать");
            }
        }else {
            System.out.println("write correct value");
        }

    }

    /*8. Метод, который считает количество раз когда его вызвали (private static над методом и
    мейном), Если его вызвали уже пятый раз и более – вывести в консоль – вы превысили
    лимит. Иначе же – вывести что-то другое.*/
    static void method8(){
        count++;
        if (count>5){
            System.out.println("you limit is end");
        }
    }

    /*9. Проверяем состояние воды. На вход получаем одно число и в зависимости от него выводим
    в консоль агрегатное состояние – лед, вода или пар.*/
    static void method9(int liquid){
        if (liquid ==0){
            System.out.println("лед");
        }else if (liquid ==1){
            System.out.println("вода");
        }else if (liquid == 2){
            System.out.println("пар");
        }else {
            System.out.println("not valid value");
        }
    }

    /*10. Нет ЛГБТ!b, бинарными операторами &&, ||. Теперь настало  – написать метод, на вход получаем 2 аргумента (сами поймете какого типа).
    Если пара гетеросексуальная, то выводим в консоль - совет вам да любовь. Если же
    гомосексуальная – то выводим в консоль – валите в США!b, бинарными операторами &&, ||. Теперь настало*/
    static void method10(int age){}

    /*11. Сравним строки. 2 строки на вход. Отдаем true только если обе строки не пустые и равны
    друг другу.*/
    static void method11(String str1,String str2){
        String checkedName = str1.trim().toLowerCase();
        String checkedName2 = str2.trim().toLowerCase();
        if (!checkedName.isEmpty() && !checkedName2.isEmpty() && checkedName.contains(checkedName2)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }

    /*12. Проверяем строку на урл. Проверить, что строка начинается с ‘http://’. Метод для
    проверки найдите сами – угадать можно число логически, просто напишите точку после
    строки и среда разработки предложит методы. По аналогии с text.isEmpty().*/
    static void method12(String isUrl){
        if (isUrl.startsWith("http://")){
            System.out.println("it`s url");
        }else{
            System.out.println("it`s not url");
        }
    }

    /*13. Метод получает на вход 5 оценок по 5-бальной шкале. Вывести строку типа – отличник,
    хорошист, троечник или двоечник исходя из среднего арифметического этих значений. Без
    округлений.*/
    static void method13(int[] marks){
        int res=0;
        for (int m :marks){
            res+=m;
        }
        double average = res/5.0;
        if (average==5){
            System.out.println(average+"отличник");
        }else if (average>=4){
            System.out.println(average+"хорошист");

        }else if (average>=3){
            System.out.println(average+"троечник");

        }else if (average>=2){
            System.out.println(average+"двоечник");

        }else{
            System.out.println("you are dumb");
        }

    }



    /*14. Нет Иванам и Ивановым. Метод на вход получает имя и фамилию по отдельности.
    Отказать человеку если его зовут Иван или же у него фамилия Иванов. А если это прям Иван
    Иванов, то вывести строку – КОМБО!b, бинарными операторами &&, ||. Теперь настало  Для всех других случаев вывести – Здравствуйте, имя
    фамилия.*/
    static void method14(String firstName,String secondName){
        if (!firstName.isEmpty() && !secondName.isEmpty()){
            if (firstName.trim().toLowerCase().contains("ivan") && secondName.trim().toLowerCase().contains("ivanov")){
                System.out.println("combo");
            }else if (firstName.trim().toLowerCase().contains("ivan") || secondName.trim().toLowerCase().contains("ivanov")){
                System.out.println("you are not welcome");
            }else {
                System.out.println("you are welcome");
            }
        }else {
            System.out.println("empty value");
        }
    }

}



