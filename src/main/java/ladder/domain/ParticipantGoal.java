package ladder.domain;

public class ParticipantGoal {

    private Participant participant;
    private Goal goal;

    public ParticipantGoal(Participant participant, Goal goal) {
        this.participant = participant;
        this.goal = goal;
    }

    public Participant getParticipant() {
        return participant;
    }

    public Goal getGoal() {
        return goal;
    }
}
