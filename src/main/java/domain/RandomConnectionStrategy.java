package domain;

public class RandomConnectionStrategy implements ConnectionStrategy {

    @Override
    public boolean shouldConnect() {
        return Math.random() < 0.5;
    }
}
