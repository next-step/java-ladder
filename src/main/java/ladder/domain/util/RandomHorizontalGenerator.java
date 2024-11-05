package ladder.domain.util;

public class RandomHorizontalGenerator implements HorizontalGenerator {
    @Override
    public Boolean generate() {
        return Math.random() > 0.5d;
    }
}
