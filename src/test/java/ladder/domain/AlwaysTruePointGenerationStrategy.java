package ladder.domain;

public class AlwaysTruePointGenerationStrategy implements PointGenerationStrategy {
    @Override
    public boolean generate() {
        return true;
    }
}
