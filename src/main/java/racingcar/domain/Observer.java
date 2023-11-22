package racingcar.domain;

import java.util.List;

public interface Observer {
    void printSnapshot(List<CarInfo> snapshot);
}
