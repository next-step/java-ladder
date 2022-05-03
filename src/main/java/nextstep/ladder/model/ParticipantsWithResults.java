package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.List;
import java.util.function.Function;

public final class ParticipantsWithResults {

    private final Participants participants;
    private final Results results;

    private ParticipantsWithResults(Participants participants, Results results) {
        Assert.notNull(participants, "participants must not be null");
        Assert.notNull(results, "results must not be null");
        validateSameSize(participants, results);
        this.participants = participants;
        this.results = results;
    }

    public static ParticipantsWithResults of(Participants participants, Results results) {
        return new ParticipantsWithResults(participants, results);
    }

    int size() {
        return participants.size();
    }

    public boolean isNotExistParticipant(Participant participant) {
        return participants.isNotExist(participant);
    }

    public int participantIndexOf(Participant participant) {
        return participants.indexOf(participant);
    }

    public Result result(int index) {
        return results.result(index);
    }

    public <T> List<T> participantMap(Function<Participant, T> participantFunction) {
        return participants.map(participantFunction);
    }

    public Participants participants() {
        return participants;
    }

    public Results results() {
        return results;
    }

    private void validateSameSize(Participants participants, Results results) {
        if (results.hasDifferentSize(participants.size())) {
            throw new IllegalArgumentException(String.format("participants(%s) size and results(%s) size must be equal", participants, results));
        }
    }

    @Override
    public String toString() {
        return "CustomEnvironment{" +
                "participants=" + participants +
                ", results=" + results +
                '}';
    }
}
