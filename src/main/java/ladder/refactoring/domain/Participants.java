package ladder.refactoring.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Participants {
    private static final int PARTICIPANTS_LIMIT = 2;
    private static final String DELIMITER = ",";

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(String input) {
        if (input == null || input.isEmpty()) {
            throw new NullPointerException("주어진 인풋이 없습니다.");
        }

        String[] names = input.split(DELIMITER);
        List<Participant> participants = Stream.iterate(0, position -> position + 1)
                .limit(names.length)
                .map(position -> Participant.of(position, names[position]))
                .distinct()
                .collect(Collectors.toList());

        validationCheck(participants, names);
        return new Participants(new ArrayList<>(participants));
    }

    private static void validationCheck(List<Participant> participants, String[] names) {
        if (names.length < PARTICIPANTS_LIMIT) {
            throw new IllegalArgumentException("적어도 2명은 참여해야합니다.");
        }
        if (participants.size() != names.length) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public int size() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return participants.stream()
                .map(participant -> String.format("%-7s", participant.toString()))
                .collect(Collectors.joining(""));
    }
}
