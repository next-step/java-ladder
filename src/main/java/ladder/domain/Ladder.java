package ladder.domain;

import java.util.ArrayList;
import java.util.List;


public class Ladder {

    private LadderHeight height;
    private LadderWidth width;

    private List<LadderLine> ladderLines;

    private Ladder(int height, int width) {
        this.height = LadderHeight.from(height);
        this.width = LadderWidth.from(width);
        ladderLines = new ArrayList<>();
    }

    public static Ladder from(int height, int width) {
        return new Ladder(height, width);
    }

    public List<LadderLine> generateLadder(Conditional conditional) {
        for (int i = 0; i < height.size(); i++) {
            ladderLines.add(conditional.generateLine(width));
        }
        return ladderLines;
    }

    public Position calculatePosition(Position position) {
        for (LadderLine line : ladderLines) {
            if(position.isNotEndPosition(line.pointCount()) && position.isExistRightPoint(line)) {
                position.moveRightPosition();
                continue;
            }

            if(position.isNotStartPosition() && position.isExistLeftPoint(line)) {
                position.moveLeftPosition();
                continue;
            }
        }
        return position;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LadderLine line : ladderLines) {
            stringBuilder.append(line.toString()+"\n");
        }
        return stringBuilder.toString();
    }
}
