package nextstep.dto;

import java.util.List;

public class LadderDTO {

    private final List<List<Boolean>> ladder;

    public LadderDTO(List<List<Boolean>> ladder) {
        this.ladder = ladder;
    }

    public List<List<Boolean>> getLadder() {
        return this.ladder;
    }
}
