package nextstep.ladder.domain.participant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    public Participants(final String names) {
        this.participants = this.splitParticipants(names);
    }


    private List<Participant> splitParticipants(String names) {
        this.checkNames(names);

        return Arrays.stream(names.split(","))
                .map(name -> new Participant(new Name(name)))
                .collect(Collectors.toList());
    }

    private void checkNames(String names) {
        if (names == null || names.isBlank()) {
            throw new IllegalArgumentException("참여자 이름은 빈값일 수 없습니다.");
        }
    }

    public List<String> getNames() {
        return this.participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }
}
