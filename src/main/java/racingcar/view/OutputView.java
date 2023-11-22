package racingcar.view;

import static racingcar.utils.Console.*;

import java.util.List;
import racingcar.domain.CarInfo;

public class OutputView {
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String SKID_MARK = "-";
    private static final String WINNER = "최종 우승자";
    private static final String WINNER_DELIMITER = ", ";
    private static final String RACE_RESULT = "실행 결과";

    public void printRaceResultMessage() {
        println();
        println(RACE_RESULT);
    }

    public void printRaceResult(List<List<CarInfo>> snapshots) {
        for (List<CarInfo> snapshot : snapshots) {
            for (CarInfo carInfo : snapshot) {
                println(carInfo.getName() + NAME_POSITION_SEPARATOR + SKID_MARK.repeat(carInfo.getPosition()));
            }
        }
        println();
    }

    public void printWinners(List<String> winners) {
        String winner = String.join(WINNER_DELIMITER, winners);
        println(WINNER + NAME_POSITION_SEPARATOR + winner);
    }
}
