package nextstep.laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<String> participants) {
        this.participants = IntStream.range(0, participants.size())
                .mapToObj(position -> new Participant(participants.get(position), position))
                .collect(Collectors.toList());
    }

    private Participants(Participant[] participants) {
        this.participants = Arrays.asList(participants);
    }

    public static Participants from(Participant participant) {
        return new Participants(new Participant[]{participant});
    }

    public List<Participant> values() {
        return participants;
    }

    public Participant getParticipantBy(String inputParticipantName) {
        return this.participants.stream()
                .filter(participant -> participant.isNameEquals(inputParticipantName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("이름이 '%s'인 참가자는 존재하지 않습니다.", inputParticipantName)));
    }

}
