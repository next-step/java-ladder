package nextstep.ladder.domain;

public class ConnectionStatus {

    private final boolean status;

    public ConnectionStatus(boolean status) {
        this.status = status;
    }

    public boolean isConnected() {
        return status;
    }

    @Override
    public String toString() {
        return "ConnectionStatus{" +
                "status=" + status +
                '}';
    }

}
