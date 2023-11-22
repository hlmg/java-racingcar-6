package racingcar.view;

import static racingcar.utils.Console.*;

import java.util.List;

public class InputView {
    private static final String INPUT_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NOT_NUMERIC = "숫자를 입력해주세요";
    private static final String NAME_SEPARATOR = ",";

    public int getAttemptCount() {
        println(INPUT_ATTEMPT_COUNT);
        return parseInt(readLine());
    }

    public List<String> getNames() {
        println(INPUT_CAR_NAMES);
        return List.of(readLine().split(NAME_SEPARATOR));
    }

    private int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC);
        }
    }
}
