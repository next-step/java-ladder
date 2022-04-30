package nextstep.ladder.model;

import nextstep.common.Assert;

public final class CustomEnvironment {

    private final Participants participants;
    private final Results results;

    private CustomEnvironment(Participants participants, Results results) {
        Assert.notNull(participants, "participants must not be null");
        Assert.notNull(results, "results must not be null");
        validateSameSize(participants, results);
        this.participants = participants;
        this.results = results;
    }

    public static CustomEnvironment of(Participants participants, Results results) {
        return new CustomEnvironment(participants, results);
    }

    int size() {
        return participants.size();
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
