package nextstep.ladder.domain;

public class RandomLineGenerateStrategy implements LineGenerateStrategy {

    @Override
    public boolean generate() {
        return Math.random() < 0.5;
    }
}
