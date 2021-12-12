package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Participants {

    private static final String INPUT_STRING_REGEX = ",";

    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants create(String input) {
        AtomicInteger position = new AtomicInteger(0);

        return new Participants(
            Arrays.stream(input.split(INPUT_STRING_REGEX))
                .map(name -> new Participant(name, position.getAndIncrement()))
                .collect(Collectors.toList()));
    }

    public Participants execute(Ladder ladder) {
        List<Participant> collect = participants.stream()
            .map(participant -> participant.climb(ladder))
            .collect(Collectors.toList());

        return new Participants(collect);
    }

    public Participant findByName(String name) {
        return participants.stream()
            .filter(participant -> participant.isEqualsName(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("사용자 이름을 찾을 수 없어요."));
    }

    public int size() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }
}
