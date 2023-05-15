package nextstep.ladder;

public class RepeatStatus {

    private boolean repeat;

    public RepeatStatus(boolean repeat) {
        this.repeat = repeat;
    }

    public boolean repeatable() {
        return repeat;
    }

    public void stop() {
        repeat = false;
    }

}
