package racingcar.domain;

public class CarInfo {
    private final String name;
    private final int position;

    private CarInfo(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarInfo from(Car car) {
        return new CarInfo(car.getName(), car.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
