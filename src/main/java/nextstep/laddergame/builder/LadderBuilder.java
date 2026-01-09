package nextstep.laddergame.builder;

import java.util.List;
import nextstep.laddergame.domain.Goal;
import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Line;

public class LadderBuilder {

    private List<Line> lines;
    private List<Goal> goals;

    public static Ladder aLadderBuilder() {
        return new LadderBuilder()
            .withLines(
                List.of(
                    new Line(() -> List.of(true, false, false)),
                    new Line(() -> List.of(false, true, false)),
                    new Line(() -> List.of(true, false, false))
                )
            ).withGoals(
                List.of(new Goal("꽝"), new Goal("당첨"), new Goal("아슬"))
            ).build();
    }

    public static String aLadderResult(int startPoint) {
        return aLadderBuilder().goals().get(startPoint).goal();
    }

    private LadderBuilder() {
    }

    private LadderBuilder(LadderBuilder copy) {
        this.lines = copy.lines;
        this.goals = copy.goals;
    }

    public LadderBuilder withLines(List<Line> lines) {
        this.lines = lines;
        return this;
    }

    public LadderBuilder withGoals(List<Goal> goals) {
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
