package nextstep.ladder.dto;

import java.util.List;

public class LadderGameRequest {

    private List<String> names;
    private int height;

    public LadderGameRequest(List<String> names, int height) {
        this.names = names;
        this.height = height;
    }

    public List<String> getNames() {
        return names;
    }

    public int getHeight() {
        return height;
    }
}
