package nextstep.ladder.domain;

public class PlayResult {
    private int source;
    private int target;

    public PlayResult(final int source, final int target) {
        this.source = source;
        this.target = target;
    }

    public int getSource() {
        return source;
    }

    public int getTarget() {
        return target;
    }
}
