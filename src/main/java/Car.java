public class Car {
    private final String name;
    private final int speed;
    private int distance;

    public Car(String name, int speed){
        this.name = name;
        this.speed = speed;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }
    public int getDistance(){
        return distance;
    }
    public int getSpeed(){
        return speed;
    }
    public String getName(){
        return name;
    }
}
