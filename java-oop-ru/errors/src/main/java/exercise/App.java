package exercise;

public class App {

    public static void printSquare(Circle circle)  throws NegativeRadiusException{
        try {
            System.out.println(Math.round((circle.getSquare())));
            System.out.println("Вычисление окончено");
        } catch (NegativeRadiusException n) {
            System.out.println("Не удалось посчитать площадь");
            System.out.println("Вычисление окончено");
        }
    }

}
