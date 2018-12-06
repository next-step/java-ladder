package dto;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {

    private List<Line> lines = new ArrayList<>();
    private Score score;

    public LadderResult() {
    }

    public LadderResult(List<Line> lines, Score score) {
        this.lines = lines;
        this.score = score;
    }

    public List<Line> ofladder() {
        return this.lines;
    }

    public int lastIndex(int n){
        int moveIndex = n;
        for(Line line : this.lines){
            moveIndex = line.move(moveIndex);
        }
        return moveIndex;
    }

    public void addLine(Line line) {
        this.lines.add(line);
    }

    public Score getScore() {
        return score;
    }
}
