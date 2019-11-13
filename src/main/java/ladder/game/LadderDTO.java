package ladder.game;

import java.util.List;

public class LadderDTO {
    private List<List<Boolean>> ladder;

    public LadderDTO(List<List<Boolean>> ladder) {
        this.ladder = ladder;
    }

    public List<List<Boolean>> getLadder() {
        return ladder;
    }
}
