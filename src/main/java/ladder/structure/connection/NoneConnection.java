package ladder.structure.connection;

public class NoneConnection implements ConnectionStrategy {
    @Override
    public boolean create() {
        return false;
    }
}
