package racingcar.domain;

import java.util.Objects;

public class Position {
    private int currentPosition;

    public Position(int position) {
        this.currentPosition = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    public void increase() {
        currentPosition++;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position position)) {
            return false;
        }
        return currentPosition == position.currentPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPosition);
    }
}
