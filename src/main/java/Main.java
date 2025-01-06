import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static Race race;
    public static void main(String[] args) {
        System.out.println("Добро пожаловать на 24 часа Ле-Мана");
        System.out.println("Тут три автомобиля будут соревноваться между собой");
        System.out.println("Правила просты: кто проедет больше за 24 часа, тот и победил");
        System.out.println("Ну чтож начнём!");

        race = new Race();

        // производиться регистация 3ёх машин
        registrationCar();

        System.out.println("Все учатсники известны. Пора начинать гонку");
        race.startRace();
        System.out.println("Невероятная гонка!");
        System.out.println("Давайте же определим победителя");

        race.checkWinner();
        HashSet<Car> winners = race.getWinnerCar();
        if(winners.size() > 1)
            System.out.println("Ого, у нас несколько победителей:");
        else
            System.out.println("Наш победитель:");
        for(Car car: winners)
            System.out.println(car.getName() + " проехавший дистанцию в " + car.getDistance() + " км");
        System.out.println("Всем спасибо за эту гонку!");
        System.out.println("Ждём вас на следующих заездах");
    }

    private static void registrationCar(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 1; i <= 3; i++){
            System.out.println("Введите имя автомобиля №" + i);
            String name = scanner.next();
            int speed;
            while (true){
                System.out.println("Введите скорость автомобиля №" + i);
                // Если пользователь ввёл не целое число, то в переменную speed запишется значение -1
                // Которое в любом случае не входит в диапазон
                speed = scanner.hasNextInt() ? scanner.nextInt() : -1;
                if(speed > 0 && speed <= 250)
                    break;
                else{
                    System.out.println("Скорость автомобиля должна быть целым число и находится в диапозоне от 0 до 250");
                    scanner.next();
                }
            }
            Car car = new Car(name, speed);
            race.addCar(car);
        }
    }
}