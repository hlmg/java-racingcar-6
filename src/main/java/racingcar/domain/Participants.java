package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Participants {
    private static final String DUPLICATED_NAME = "경주에 참가하는 자동차 이름은 중복될 수 없습니다";
    private static final String MIN_PARTICIPANTS = "경주에 참가하는 자동차는 최소 두 대 이상이어야 합니다";
    private static final int MIN_PARTICIPANTS_SIZE = 2;
    private final List<Observer> observers = new ArrayList<>();
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

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void race() {
        cars.forEach(Car::moveForward);
        List<CarInfo> carInfos = cars.stream()
                .map(CarInfo::from)
                .toList();

        for (Observer observer : observers) {
            observer.printSnapshot(carInfos);
        }
    }

    public List<String> getWinners() {
        Car first = findFirst();

        return cars.stream()
                .filter(car -> car.isSamePosition(first))
                .map(Car::getName)
                .toList();
    }

    private Car findFirst() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow();
    }
}
