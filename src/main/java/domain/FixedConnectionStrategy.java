package domain;

public class FixedConnectionStrategy implements ConnectionStrategy{
    @Override
    public boolean shouldConnect() {
        return true;
    }
}
