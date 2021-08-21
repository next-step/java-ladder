package ladder.strategy;

public class NoMovableStrategy implements MovableStrategy {
    @Override
    public boolean isMovable() {
        return false;
    }
}
