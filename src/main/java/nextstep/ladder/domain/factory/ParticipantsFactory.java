package nextstep.ladder.domain.factory;

import nextstep.ladder.domain.participant.Participant;
import nextstep.ladder.domain.participant.Participants;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipantsFactory {

    public static Participants generateByUserNames(List<String> userNames) {
        return new Participants(
                userNames.stream()
                        .map(Participant::new)
                        .collect(Collectors.toList())
        );
    }
}
