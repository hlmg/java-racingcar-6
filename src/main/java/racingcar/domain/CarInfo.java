package racingcar.domain;

public class CarInfo {
    private final String name;
    private final int position;

    private CarInfo(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarInfo from(String name, int position) {
        return new CarInfo(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
