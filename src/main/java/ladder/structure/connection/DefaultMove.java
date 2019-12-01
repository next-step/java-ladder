package ladder.structure.connection;

public class DefaultMove implements MoveStrategy {
    @Override
    public boolean isMovableToRight() {
        return true;
    }
}
