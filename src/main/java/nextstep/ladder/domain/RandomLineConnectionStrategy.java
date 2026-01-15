package nextstep.ladder.domain;

public class RandomLineConnectionStrategy implements LineConnectionStrategy {
    @Override
    public boolean hasConnection(boolean previousRight) {
        if (previousRight) {
            return false;
        }
        return Math.random() < 0.5;
    }
}