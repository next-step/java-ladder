package nextstep.ladder.dto;

import java.util.List;

public class Connections {

    private final List<Boolean> connectionList;

    public Connections(List<Boolean> connectionList) {
        this.connectionList = connectionList;
    }

    public List<Boolean> getConnectionList() {
        return connectionList;
    }
}
