package racingcar.domain;

import java.util.HashSet;
import java.util.List;

public class Participants {
    private static final String DUPLICATED_NAME = "경주에 참가하는 자동차 이름은 중복될 수 없습니다";
    private static final String MIN_PARTICIPANTS = "경주에 참가하는 자동차는 최소 두 대 이상이어야 합니다";
    private static final int MIN_PARTICIPANTS_SIZE = 2;

    private final List<Car> cars;

    public Participants(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        validateMinParticipants(cars);
        validateDuplicate(cars);
    }

    private void validateMinParticipants(List<Car> cars) {
        if (cars.size() < MIN_PARTICIPANTS_SIZE) {
            throw new IllegalArgumentException(MIN_PARTICIPANTS);
        }
    }

    private void validateDuplicate(List<Car> cars) {
        HashSet<Car> distinctCars = new HashSet<>();
        for (Car car : cars) {
            if (!distinctCars.add(car)) {
                throw new IllegalArgumentException(DUPLICATED_NAME);
            }
        }
    }

    public List<Car> race() {
        cars.forEach(Car::moveForward);

        return deepCopyFrom(cars);
    }

    private List<Car> deepCopyFrom(List<Car> cars) {
        return cars.stream()
                .map(car -> new Car(car.getName(), car.getPosition(), null))
                .toList();
    }

    public List<String> getWinners() {
        Car first = findFirst();

        return cars.stream()
                .filter(car -> isSamePosition(car, first))
                .map(Car::getName)
                .toList();
    }

    private Car findFirst() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow();
    }

    private boolean isSamePosition(Car car, Car first) {
        return car.getPosition() == first.getPosition();
    }
}
