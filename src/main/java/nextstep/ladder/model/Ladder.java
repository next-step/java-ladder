package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.List;

public final class Ladder {

    private final CustomEnvironment environment;
    private final Lines lines;

    public Ladder(CustomEnvironment environment, Lines lines) {
        Assert.notNull(environment, "environment must not be null");
        Assert.notNull(lines, "lines must not be null");
        validateSize(environment, lines);
        this.environment = environment;
        this.lines = lines;
    }

    public static Ladder of(CustomEnvironment environment, Lines lines) {
        return new Ladder(environment, lines);
    }

    public Result result(Participant participant) {
        validateParticipant(participant);
        return environment.result(
                lines.lastMovedIndex(environment.participantIndexOf(participant))
        );
    }

    public List<ParticipantResult> participantResults() {
        return environment.participantMap(participant ->
                ParticipantResult.of(participant, result(participant)));
    }

    public CustomEnvironment environment() {
        return environment;
    }

    public Lines lines() {
        return lines;
    }

    private void validateParticipant(Participant participant) {
        if (environment.isNotExistParticipant(participant)) {
            throw new IllegalStateException(String.format("participant(%s) is not exist", participant));
        }
    }

    private void validateSize(CustomEnvironment environment, Lines lines) {
        if (lines.hasDifferentPointSize(environment.size())) {
            throw new IllegalArgumentException(String.format("environment(%s) size and line(%s) points size must be equal", environment, lines));
        }
    }
}
