package racingcar.domain;

import java.util.function.IntSupplier;

public class Car implements Comparable<Car> {
    private static final String NOT_BLANK_NAME = "자동차 이름은 비어있을 수 없습니다";
    private static final String INVALID_NAME_LENGTH_FORMAT = "자동차 이름은 %d자 이하여야 합니다";
    private static final int MAX_NAME_LENGTH = 5;
    public static final int MOVE_THRESHOLD = 4;

    private final String name;
    private final IntSupplier intSupplier;
    private int position;

    public Car(String name) {
        this(name, new DefaultSupplier());
    }

    public Car(String name, IntSupplier intSupplier) {
        validateName(name);
        this.name = name;
        this.intSupplier = intSupplier;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NOT_BLANK_NAME);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_NAME_LENGTH_FORMAT, MAX_NAME_LENGTH));
        }
    }

    public void moveForward() {
        if (intSupplier.getAsInt() >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return o.getPosition() - this.position;
    }
}
