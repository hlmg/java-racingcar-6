package racingcar.domain;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public class Car implements Comparable<Car> {
    private final Name name;
    private final Position position;
    private final BooleanSupplier engine;

    public Car(String name, int position, BooleanSupplier engine) {
        this.name = Name.from(name);
        this.position = Position.from(position);
        this.engine = engine;
    }

    public void moveForward() {
        if (engine.getAsBoolean()) {
            position.increase();
        }
    }

    public int getPosition() {
        return position.getCurrentPosition();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isSamePosition(Car first) {
        return position.equals(first.position);
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
        return this.position.getCurrentPosition() - o.getPosition();
    }
}
