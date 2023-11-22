package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void run() {
        createParticipants();
        playRace();
        printWinner();
    }

    private void createParticipants() {
        List<String> names = inputView.getNames();
        racingCarService.createParticipants(names);
    }

    private void playRace() {
        int attemptCount = inputView.getAttemptCount();

        outputView.printRaceResultMessage();

        // TODO: 서비스 레이어로 이동해야 하는데 레이스 결과를 출력하는 로직이 있어서 다른 방식으로 해결해야 할듯
//        for (int i = 0; i < attemptCount; i++) {
//            List<Car> cars = participants.race();
//            outputView.printRaceResult(cars);
//        }
    }

    private void printWinner() {
        List<String> winners = racingCarService.getWinners();
        outputView.printWinners(winners);
    }
}
