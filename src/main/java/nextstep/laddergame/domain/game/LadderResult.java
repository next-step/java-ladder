package nextstep.laddergame.domain.game;

import nextstep.laddergame.domain.ladder.Goal;
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