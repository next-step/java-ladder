package nextstep.ladder.domain.participant;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Participants {
    private static final String ALL = "all";
    private final List<Participant> participants;

    public Participants(final String names) {
        this.participants = this.splitParticipants(names);
    }


    private List<Participant> splitParticipants(String names) {
        return Arrays.stream(Optional.ofNullable(names)
                        .filter(n -> !n.isBlank())
                        .map(n -> n.split(","))
                        .orElseThrow(() -> new IllegalArgumentException("참여자 이름은 빈값일 수 없습니다.")))
                .distinct()
                .filter(name -> !ALL.equals(name))
                .map(name -> new Participant(new Name(name)))
                .collect(Collectors.toList());
    }

    public int indexByName(String name) {
        final Participant target = this.participants.stream()
                .filter(participant -> participant.isParticipant(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("당첨 확인을 원하는 이름은 기존에 등록된 이름이어야 합니다."));

        return this.participants.indexOf(target);
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
