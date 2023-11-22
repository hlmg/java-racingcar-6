package racingcar.domain;

import java.util.List;
import racingcar.domain.factory.ParticipantsFactory;

public class RacingCarService {
    private final ParticipantsFactory participantsFactory;
    private final RaceRecorder raceRecorder;
    private Participants participants;


    public RacingCarService(ParticipantsFactory participantsFactory, RaceRecorder raceRecorder) {
        this.participantsFactory = participantsFactory;
        this.raceRecorder = raceRecorder;
    }

    public void createParticipants(List<String> names) {
        participants = participantsFactory.createFromNames(names);
    }

    public void race(AttemptCount attemptCount) {
        while (attemptCount.isRemain()) {
            List<Car> race = participants.race();
            raceRecorder.record(race);
            attemptCount.decrease();
        }
    }

    public List<String> getWinners() {
        return participants.getWinners();
    }

    public List<List<CarInfo>> getRaceResult() {
        return raceRecorder.getSnapshots();
    }
}
