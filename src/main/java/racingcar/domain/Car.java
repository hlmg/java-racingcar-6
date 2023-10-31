package racingcar.domain;

import java.util.Objects;
import java.util.function.IntSupplier;
import java.util.regex.Pattern;

public class Car implements Comparable<Car> {
    public static final int MOVE_THRESHOLD = 4;
    private static final int DEFAULT_CAR_POSITION = 0;

    private final String name;
    private final IntSupplier intSupplier;
    private int position;

    public Car(String name, int position, IntSupplier intSupplier) {
        NameValidator.validate(name);
        this.name = name;
        this.intSupplier = intSupplier;
        this.position = position;
    }

    public Car(String name, IntSupplier intSupplier) {
        this(name, DEFAULT_CAR_POSITION, intSupplier);
    }

    public Car(String name, int position) {
        this(name, position, RandomNumberSupplier.getInstance());
    }

    public Car(String name) {
        this(name, DEFAULT_CAR_POSITION, RandomNumberSupplier.getInstance());
    }

    public void moveForward() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return intSupplier.getAsInt() >= MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.getPosition();
    }

    private static class NameValidator {
        private static final String NOT_BLANK_NAME = "자동차 이름은 비어있을 수 없습니다";
        private static final String NO_WHITESPACE_AROUND_NAME = "자동차 이름 양 옆에 공백이 올 수 없습니다";
        private static final Pattern WHITE_SPACE_AROUND_STRING = Pattern.compile("^\\s+|\\s+$");
        private static final String INVALID_NAME_LENGTH_FORMAT = "자동차 이름은 %d자 이하여야 합니다";
        private static final int MAX_NAME_LENGTH = 5;

        private static void validate(String name) {
            validateBlank(name);
            validateWhiteSpaceAround(name);
            validateLength(name);
        }

        private static void validateBlank(String name) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(NOT_BLANK_NAME);
            }
        }

        private static void validateWhiteSpaceAround(String name) {
            if (WHITE_SPACE_AROUND_STRING.matcher(name).find()) {
                throw new IllegalArgumentException(NO_WHITESPACE_AROUND_NAME);
            }
        }

        private static void validateLength(String name) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(String.format(INVALID_NAME_LENGTH_FORMAT, MAX_NAME_LENGTH));
            }
        }
    }
}
