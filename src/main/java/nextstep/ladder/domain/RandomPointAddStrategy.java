package nextstep.ladder.domain;

public class RandomPointAddStrategy implements PointAddStrategy {
    @Override
    public boolean confirm(boolean canPlace) {
        return false;
    }
}
