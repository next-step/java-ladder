package ladder.structure.connection;

public class DefaultConnection implements ConnectionStrategy {
    @Override
    public boolean create() {
        return true;
    }
}
