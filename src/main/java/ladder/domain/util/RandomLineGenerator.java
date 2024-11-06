package ladder.domain.util;

public class RandomLineGenerator implements LineGenerator {

    public static final double BOUNDARY = 0.5d;

    @Override
    public Boolean generate() {
        return Math.random() > BOUNDARY;
    }
}
