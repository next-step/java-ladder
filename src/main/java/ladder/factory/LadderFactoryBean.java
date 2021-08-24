package ladder.factory;

import ladder.domain.ladder.ladder.LadderGenerator;
import ladder.domain.ladder.line.LineGenerator;
import ladder.domain.ladder.point.PointGenerator;
import ladder.domain.ladder.ladder.RandomLadderGenerator;
import ladder.domain.ladder.line.RandomLineGenerator;
import ladder.domain.ladder.point.RandomPointGenerator;

public class LadderFactoryBean {

    private LadderFactoryBean() {
    }

    public static PointGenerator pointGenerator() {
        return new RandomPointGenerator();
    }

    public static LineGenerator lineGenerator() {
        return new RandomLineGenerator(pointGenerator());
    }

    public static LadderGenerator ladderGenerator() {
        return new RandomLadderGenerator(lineGenerator());
    }
}
