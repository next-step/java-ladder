package nextstep.laddergame.domain;

import nextstep.laddergame.domain.participant.Name;

public record LadderResult(Name name, Goal goal) {

    public LadderResult(String name, String goal) {
        this(new Name(name), new Goal(goal));
    }

    @Override
    public String toString() {
        return "LadderResult{" +
            "name='" + name + '\'' +
            ", goal='" + goal + '\'' +
            '}';
    }
}