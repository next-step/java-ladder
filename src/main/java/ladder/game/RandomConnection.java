package ladder.game;

public class RandomConnection implements ConnectionStrategy {
    private static final int RANDOM_PERCENTAGE = 5;

    private static boolean random(Connectable connection) {
        return connection.create();
    }

    @Override
    public boolean create() {
        return random(() -> Math.random() * 10 < RANDOM_PERCENTAGE);
    }
}
