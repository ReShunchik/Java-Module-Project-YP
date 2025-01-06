import java.util.ArrayList;
import java.util.HashSet;

public class Race {
    private final ArrayList<Car> cars;
    // Поставил здесь Set, т.к. может получиться ситуация,
    // что несколько машин проедут одиннаковую дистанцию
    private final HashSet<Car> winnerCar;

    public Race(){
        cars = new ArrayList<>(3);
        winnerCar = new HashSet<>(1);
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void startRace(){
        int hours = 24;
        String format = "%s проехал %d км";
        for(Car car: cars){
            int distance = car.getSpeed() * hours;
            System.out.println(String.format(format, car.getName(), distance));
            car.setDistance(distance);
        }
    }

    public void checkWinner(){
        Car potentialWinner = cars.get(0);
        winnerCar.add(potentialWinner);
        for(int i = 1; i <= 2; i++){
            Car car = cars.get(i);
            int distance1 = potentialWinner.getDistance();
            int distance2 = car.getDistance();
            // проверяю все возможные ситуации
            if(distance1 == distance2)
                winnerCar.add(car);
            else if(distance2 > distance1){
                winnerCar.clear();
                winnerCar.add(car);
                potentialWinner = car;
            }
        }
    }

    public HashSet<Car> getWinnerCar(){
        return winnerCar;
    }
}
