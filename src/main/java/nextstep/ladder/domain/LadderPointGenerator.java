package nextstep.ladder.domain;

public class LadderPointGenerator {
    private static final RandomLadderPointStrategy strategy = new RandomLadderPointStrategy();

    public static boolean generatePoint() {
        return strategy.generatePoint();
    }
}
