package nextstep.ladder.domain;

public class RandomStrategy implements Strategy {

    @Override
    public boolean paint() {
        return Math.random() < 0.5;
    }
}
