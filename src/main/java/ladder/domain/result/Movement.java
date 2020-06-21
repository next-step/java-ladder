package ladder.domain.result;

public enum Movement {
    LEFT(-1),
    GO(0),
    STOP(+1);

    private int position;

    Movement(int position) {
        this.position = position;
    }
}
