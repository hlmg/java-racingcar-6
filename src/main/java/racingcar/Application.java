package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.RacingCarService;
import racingcar.domain.factory.CarFactory;
import racingcar.domain.factory.ParticipantsFactory;
import racingcar.domain.RandomMoveEngine;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController =
                new RacingCarController(new InputView(), new OutputView(), getRacingCarService());

        racingCarController.run();
    }

    private static RacingCarService getRacingCarService() {
        return new RacingCarService(getParticipantsFactory());
    }

    private static ParticipantsFactory getParticipantsFactory() {
        CarFactory carFactory = new CarFactory(new RandomMoveEngine());
        return new ParticipantsFactory(carFactory);
    }
}
