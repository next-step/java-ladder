package nextstep.ladder.domain.ladder;

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
