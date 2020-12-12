package step3.domain;

import step3.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
    private static final int START_POINT = 2;
    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(List<String> participants) {
        return new Participants(toParticipant(participants));
    }

    private static List<Participant> toParticipant(List<String> participants) {
        return IntStream.range(0, participants.size())
                .mapToObj(i -> Participant.of(participants.get(i), new Point(i * START_POINT, 0)))
                .collect(Collectors.toList());
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    private Participant getParticipant(String name) {
        return participants.stream()
                .filter(participant -> participant.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(name));
    }

    public Point getPoint(String name) {
        return this.getParticipant(name).getPosition();
    }
}
