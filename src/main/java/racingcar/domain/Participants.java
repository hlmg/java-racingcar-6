package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
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

    public static Participants from(List<String> names) {
        return new Participants(names.stream().map(Car::new).toList());
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
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        List<Car> candidates = new ArrayList<>(cars);
        Collections.sort(candidates);
        int first = candidates.get(0).getPosition();
        return candidates.stream()
                .filter(car -> car.getPosition() == first)
                .map(Car::getName)
                .toList();
    }
}
