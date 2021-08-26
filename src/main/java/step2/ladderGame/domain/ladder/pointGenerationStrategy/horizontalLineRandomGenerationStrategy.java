package step2.ladderGame.domain.ladder.pointGenerationStrategy;

        import step2.ladderGame.domain.ladder.Point;

        import java.util.Random;

public class horizontalLineRandomGenerationStrategy implements horizontalLineGenerationStrategy {

    private static Random random = new Random();

    public boolean createHorizontalLine(Point prePoint) {
        if (prePoint.equals(new Point(true))) {
            return false;
        }
        return random.nextBoolean();
    }

}
