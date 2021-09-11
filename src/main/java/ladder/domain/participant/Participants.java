package ladder.domain.participant;

import ladder.domain.ladder.LadderFloor;
import ladder.domain.ladder.LadderSize;
import ladder.domain.position.Position;
import ladder.exception.NoMatchOfParticipantException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Participants {
    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public Participants(String[] names, LadderSize ladderSize) {
        this(IntStream.range(0, names.length)
                .mapToObj((i) -> new Participant(names[i], new Position(i, ladderSize)))
                .collect(Collectors.toList()));
    }

    public List<Participant> getPaticipants() {
        return participants;
    }

    public void moveToDestination(List<LadderFloor> floors) {
        for (Participant participant : participants) {
            participant.moveToDestination(floors);
        }
    }

    public Participant findParticipant(String nameForResult) {
        return participants.stream()
                .filter((n) -> nameForResult.equals(n.toStringName()))
                .findFirst()
                .orElseThrow(() -> new NoMatchOfParticipantException(nameForResult));
    }

    public String[] getNameOfParticipants() {
        return participants.stream()
                .map((n) -> n.getName())
                .toArray(String[]::new);
    }
}
