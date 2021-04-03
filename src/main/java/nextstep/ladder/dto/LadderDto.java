package nextstep.ladder.dto;

import java.util.List;

public class LadderDto {

    private final List<Connections> connectionsList;

    public LadderDto(List<Connections> connectionsList) {
        this.connectionsList = connectionsList;
    }

    public List<Connections> getConnectionsList() {
        return connectionsList;
    }

}
