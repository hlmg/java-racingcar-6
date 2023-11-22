package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceRecorder {
    private final List<List<CarInfo>> snapshots;

    public RaceRecorder() {
        this.snapshots = new ArrayList<>();
    }

    public void record(List<Car> cars) {
        List<CarInfo> snapshot = cars.stream()
                .map(car -> CarInfo.from(car.getName(), car.getPosition()))
                .toList();

        snapshots.add(snapshot);
    }

    public List<List<CarInfo>> getSnapshots() {
        return snapshots;
    }
}
