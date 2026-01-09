package nextstep.laddergame.builder;

import java.util.List;
import nextstep.laddergame.domain.ladder.Goal;
import nextstep.laddergame.domain.ladder.Goals;
import nextstep.laddergame.domain.ladder.Ladder;
import nextstep.laddergame.domain.ladder.Line;
import nextstep.laddergame.domain.ladder.Lines;

public class LadderBuilder {

    private Lines lines;
    private Goals goals;

    public static Ladder aLadderBuilder() {
        return new LadderBuilder()
            .withLines(
                new Lines(
                    new Line(() -> List.of(true, false, false)),
                    new Line(() -> List.of(false, true, false)),
                    new Line(() -> List.of(true, false, false))
                )
            ).withGoals(
                new Goals(
                    List.of(new Goal("꽝"), new Goal("당첨"), new Goal("아슬"))
                )
            ).build();
    }

    public static String aLadderResult(int startPoint) {
        return aLadderBuilder().goals().goalList().get(startPoint).value();
    }

    private LadderBuilder() {
    }

    private LadderBuilder(LadderBuilder copy) {
        this.lines = copy.lines;
        this.goals = copy.goals;
    }

    public LadderBuilder withLines(Lines lines) {
        this.lines = lines;
        return this;
    }

    public LadderBuilder withGoals(Goals goals) {
        this.goals = goals;
        return this;
    }

    public Ladder build() {
        return new Ladder(lines, goals);
    }

    public LadderBuilder but() {
        return new LadderBuilder(this);
    }

}
