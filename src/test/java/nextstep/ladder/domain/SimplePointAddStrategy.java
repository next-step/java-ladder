package nextstep.ladder.domain;

public class SimplePointAddStrategy implements PointAddStrategy {
    @Override
    public boolean confirm(boolean canPlace) {
        return canPlace;
    }
}
