package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.Objects;

public final class ParticipantResult {

    private final Participant participant;
    private final Result result;

    private ParticipantResult(Participant participant, Result result) {
        Assert.notNull(participant, "participant must not be null");
        Assert.notNull(result, "result must not be null");
        this.participant = participant;
        this.result = result;
    }

    static ParticipantResult of(Participant participant, Result result) {
        return new ParticipantResult(participant, result);
    }

    public Participant participant() {
        return participant;
    }

    public Result result() {
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant, result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParticipantResult that = (ParticipantResult) o;
        return Objects.equals(participant, that.participant) && Objects.equals(result, that.result);
    }
}
