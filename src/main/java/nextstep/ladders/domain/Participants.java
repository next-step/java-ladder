package nextstep.ladders.domain;

import nextstep.ladders.exception.NotFoundDataException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String REGEX_COMMA = ",";

    private final List<Participant> participants;

    public Participants(final String participantsText) {
        List<String> names = parseParticipants(participantsText);
        this.participants = names.stream()
                .map(Participant::valueOf)
                .collect(Collectors.toList());
    }

    public int indexOf(final Participant participant) {
        int index = this.participants.indexOf(participant);
        if (index == -1) {
            throw new NotFoundDataException("참가자를 찾을 수 없습니다.");
        }
        return index;
    }

    private List<String> parseParticipants(final String participantsText) {
        return Arrays.stream(participantsText.split(REGEX_COMMA))
                .collect(Collectors.toList());
    }

    public List<Participant> elements() {
        return Collections.unmodifiableList(participants);
    }
}
