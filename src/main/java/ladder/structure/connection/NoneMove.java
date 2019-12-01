package ladder.structure.connection;

public class NoneMove implements MoveStrategy {
    @Override
    public boolean isMovableToRight() {
        return false;
    }
}
