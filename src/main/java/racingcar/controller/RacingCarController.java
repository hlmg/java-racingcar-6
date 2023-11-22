package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
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

        for (int i = 0; i < attemptCount; i++) {
            List<Car> cars = racingCarService.race();
            outputView.printRaceResult(cars);
        }
    }

    private void printWinner() {
        List<String> winners = racingCarService.getWinners();
        outputView.printWinners(winners);
    }
}
