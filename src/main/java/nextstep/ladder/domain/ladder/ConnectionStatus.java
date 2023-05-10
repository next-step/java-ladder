package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class ConnectionStatus {

    private final boolean status;

    public ConnectionStatus(boolean status) {
        this.status = status;
    }

    public boolean isConnected() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectionStatus that = (ConnectionStatus) o;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    @Override
    public String toString() {
        return "ConnectionStatus{" +
                "status=" + status +
                '}';
    }

}
