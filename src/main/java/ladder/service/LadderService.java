package ladder.service;

import ladder.domain.Lines;
import ladder.domain.Participants;

public class LadderService {

    public static Participants createParticipants(String participants) {
        return Participants.from(participants);
    }

    public static Lines createLines(int size, int height) {
        return new Lines(size, height);
    }
}
