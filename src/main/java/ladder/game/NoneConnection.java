package ladder.game;

public class NoneConnection implements ConnectionStrategy {
    @Override
    public boolean create() {
        return false;
    }
}
