package ladder.model;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private static final int MINIMUM_NUMBER_OF_PARTICIPANTS = 2;
    private static final String MESSAGE_OF_MINIMUM_PARTICIPANTS_EXCEPTION = "참가자 수는 최소 %d 이상이어야 합니다.";

    private final List<Participant> participants;

    public Participants(List<String> names) {
        if (names.size() < MINIMUM_NUMBER_OF_PARTICIPANTS) {
            throw new IllegalArgumentException(
                    String.format(MESSAGE_OF_MINIMUM_PARTICIPANTS_EXCEPTION, MINIMUM_NUMBER_OF_PARTICIPANTS));
        }

        participants = names.stream()
                            .map(Participant::new)
                            .collect(Collectors.collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public int size() {
        return participants.size();
    }

    public Participant getParticipant(int index) {
        return participants.get(index);
    }
}
