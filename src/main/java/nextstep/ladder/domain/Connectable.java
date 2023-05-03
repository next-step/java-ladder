package nextstep.ladder.domain;

public class Connectable {

    private final boolean status;

    public Connectable(boolean status) {
        this.status = status;
    }

    public boolean isConnected() {
        return status;
    }

}
