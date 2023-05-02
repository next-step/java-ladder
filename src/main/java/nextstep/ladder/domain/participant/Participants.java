package nextstep.ladder.domain.participant;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    public Participants(final String names) {
        this.participants = this.splitParticipants(names);
    }


    private List<Participant> splitParticipants(String names) {
        final List<String> nameList = List.of(Optional.ofNullable(names)
                .filter(n -> !n.isBlank())
                .map(n -> n.split(","))
                .orElseThrow(() -> new IllegalArgumentException("참여자 이름은 빈값일 수 없습니다.")));

        return nameList.stream()
                .map(name -> new Participant(new Name(name)))
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return this.participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public int getSize() {
        return this.participants.size();
    }
}
