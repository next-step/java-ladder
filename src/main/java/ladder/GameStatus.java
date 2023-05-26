package ladder;

public class GameStatus {
    private boolean repeat;

    public GameStatus(boolean repeat) {
        this.repeat = repeat;
    }

    public boolean repeatable() {
        return repeat;
    }

    public void stop() {
        repeat = false;
    }
}
