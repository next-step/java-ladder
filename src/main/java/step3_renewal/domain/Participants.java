package step3_renewal.domain;

import step3_renewal.exception.MinimumNumberOfPersonException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
    private static final Integer MIN_NUMBER = 2;

    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(List<String> participants) {
        validate(participants);
        return new Participants(toParticipant(participants));
    }

    private static List<Participant> toParticipant(List<String> participants) {
        return IntStream.range(0, participants.size())
                .mapToObj(i -> Participant.of(participants.get(i), i))
                .collect(Collectors.toList());
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    private static void validate(List<String> participants) {
        if (participants.size() < MIN_NUMBER) {
            throw new MinimumNumberOfPersonException(MIN_NUMBER);
        }
    }

    public int size() {
        return participants.size();
    }
}
