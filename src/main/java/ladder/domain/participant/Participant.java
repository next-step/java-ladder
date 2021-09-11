package ladder.domain.participant;

import ladder.domain.ladder.LadderFloor;
import ladder.domain.position.Position;
import ladder.domain.name.ParticipantName;

import java.util.List;

public class Participant {
    private final ParticipantName name;
    private Position position;

    public Participant(ParticipantName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Participant(String name, Position position) {
        this(new ParticipantName(name), position);
    }

    public String toStringName() {
        return name.toString();
    }

    public void moveToDestination(List<LadderFloor> floors) {
        for (LadderFloor ladderFloor : floors) {
            position = position.move(ladderFloor.getLines());
        }
    }

    public String getName() {
        return name.toString();
    }

    public boolean hasEqualPosition(Position position) {
        return position.equals(this.position);
    }
}
