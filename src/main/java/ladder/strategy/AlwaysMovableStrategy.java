package ladder.strategy;

public class AlwaysMovableStrategy implements MovableStrategy {
    @Override
    public boolean isMovable() {
        return true;
    }
}
