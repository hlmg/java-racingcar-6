package racingcar.domain;

import java.util.List;
import racingcar.domain.factory.ParticipantsFactory;

public class RacingCarService {
    private final ParticipantsFactory participantsFactory;
    private Participants participants;

    public RacingCarService(ParticipantsFactory participantsFactory) {
        this.participantsFactory = participantsFactory;
    }

    public void createParticipants(List<String> names) {
        participants = participantsFactory.createFromNames(names);
    }

    public void race(int attemptCount) {
        // TODO: 구현
    }

    public List<String> getWinners() {
        return participants.getWinners();
    }
}
