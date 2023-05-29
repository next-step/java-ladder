package ladder.dto;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(int ladderHeight, Players players) {
        validateLadderHeight(ladderHeight);

        for(int i=0; i < ladderHeight; i++){
            lines.add(new Line(players.getCountOrPerson()));
        }
    }

    public static void validateLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException("양수만 가능합니다.");
        }
    }

    public List<Line> getLines(){
        return this.lines;
    }
}
