package nextstep.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 전체 인원
 */
public class Participants {
    private final List<Participant> participants;

    /* 생성 메서드 */
    public Participants(String names) {
        List<Participant> list = splitAndTrim(names);
        validate(list);
        this.participants = list;
    }

    private void validate(List<Participant> participants) {
        Set<Participant> uniqueParticipants = new HashSet<>(participants);
        if (uniqueParticipants.size() != participants.size()) {
            throw new IllegalArgumentException("중복된 이름은 올 수 없습니다.");
        }
    }

    private List<Participant> splitAndTrim(String input) {
        String[] participants = input.split(",");
        return IntStream.range(0, participants.length)
            .mapToObj(i -> new Participant(participants[i].trim(), i))
            .collect(Collectors.toList());
    }

    /* 이름으로 참여자 찾기 */
    public Optional<Participant> findByName(String name) {
            return participants.stream()
                .filter((p) -> p.isSameName(name))
                .findFirst();
    }

    /* 정보성 메서드 */
    public int size() {
            return participants.size();
        }

    public List<Participant> unmodifiableNames() {
        return Collections.unmodifiableList(participants);
    }

}
