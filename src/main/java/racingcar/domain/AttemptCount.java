package racingcar.domain;

public class AttemptCount {
    private static final String INVALID_ATTEMPT_COUNT = "시도 횟수는 1 이상이어야 합니다";
    private static final int MIN_ATTEMPT_COUNT = 1;

    private int remainCount;

    private AttemptCount(int attemptCount) {
        validate(attemptCount);
        this.remainCount = attemptCount;
    }

    public static AttemptCount from(int attemptCount) {
        return new AttemptCount(attemptCount);
    }

    private void validate(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }

    public boolean isRemain() {
        return remainCount > 0;
    }

    public void decrease() {
        remainCount--;
    }
}
