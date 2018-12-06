package dto;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {

    private List<LadderLine> lines = new ArrayList<>();
    private Score score;

    public LadderResult() {
    }

    public LadderResult(List<LadderLine> lines, Score score) {
        this.lines = lines;
        this.score = score;
    }

    public List<LadderLine> ofladder() {
        return this.lines;
    }

    public int lastIndex(int n){
        int moveIndex = n;
        for(LadderLine line : this.lines){
            moveIndex = line.move(moveIndex);
        }
        return moveIndex;
    }

    public void addLine(LadderLine line) {
        this.lines.add(line);
    }

    public Score getScore() {
        return score;
    }
}
