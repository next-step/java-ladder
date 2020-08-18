package ladder.domain.core;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static ladder.domain.core.Participant.verifyBlankName;

class Participants {
    public static final String SEPARATOR = ",";
    private final List<Participant> participants;
    Participants(String participants) {
        verifyBlankName(participants);
        List<Participant> participantList = Stream.of(participants.split(SEPARATOR))
                                                  .map(Participant::new)
                                                  .collect(toList())
            ;
        this.participants = Collections.unmodifiableList(participantList);
    }

    int getCount() {
        return participants.size();
    }
}
