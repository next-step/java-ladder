package nextstep.ladder.model;

public class NoLineDrawStrategy implements LineDrawStrategy {
    @Override
    public boolean decideToDraw() {
        return false;
    }
}
