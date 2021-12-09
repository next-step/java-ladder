package nextstep.laddergame.model;

public class Result {

    private final Participant participant;
    private final Goal goal;

    public Result(Participant participant, Goal goal) {
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
