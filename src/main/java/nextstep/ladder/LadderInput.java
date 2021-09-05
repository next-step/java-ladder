package nextstep.ladder;

import nextstep.ladder.participant.Participants;

public class LadderInput {
    private Participants participants;
    private RandomPoint randomPoint;
    private int depth;

    public LadderInput(Participants participants, int depth) {
        this.participants = participants;
        this.depth = depth;
    }

    public Participants getParticipants() {
        return participants;
    }

    public RandomPoint getRandomPoint() {
        return randomPoint;
    }

    public int getDepth() {
        return depth;
    }

    public void setRandomPoint(RandomPoint randomPoint) {
        this.randomPoint = randomPoint;
    }
}
