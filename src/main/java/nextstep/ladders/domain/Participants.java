package nextstep.ladders.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    public static final String REGEX_COMMA = ",";

    private List<Participant> participants;

    public Participants(final String participantsText) {
        List<String> names = parseParticipants(participantsText);
        this.participants = names.stream()
                .map(Participant::valueOf)
                .collect(Collectors.toList());
    }

    private List<String> parseParticipants(final String participantsText) {
        return Arrays.stream(participantsText.split(REGEX_COMMA))
                .collect(Collectors.toList());
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public int count() {
        return participants.size();
    }
}
