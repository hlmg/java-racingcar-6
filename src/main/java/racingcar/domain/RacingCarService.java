package racingcar.domain;

import java.util.List;
import racingcar.domain.factory.ParticipantsFactory;

public class RacingCarService {
    private final ParticipantsFactory participantsFactory;
    private Participants participants;


    public RacingCarService(ParticipantsFactory participantsFactory) {
        this.participantsFactory = participantsFactory;
    }

    public void createParticipants(List<String> names, Observer observer) {
        participants = participantsFactory.createFromNames(names);
        participants.registerObserver(observer);
    }

    public void race(AttemptCount attemptCount) {
        while (attemptCount.isRemain()) {
            participants.race();
            attemptCount.decrease();
        }
    }

    public List<String> getWinners() {
        return participants.getWinners();
    }
}
