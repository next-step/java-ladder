package ladder.dto;

import java.util.ArrayList;
import java.util.List;

public class LadderLineDTO {

    List<List<Boolean>> ladderLine = new ArrayList<>();

    public List<List<Boolean>> getLadderLine() {
        return ladderLine;
    }

    public void setLadderLine(List<List<Boolean>> ladderLine) {
        this.ladderLine = ladderLine;
    }
}
