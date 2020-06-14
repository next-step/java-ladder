package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PositionLog {

    private final List<Integer> positions;

    private PositionLog(int initialPosition) {
        positions = new ArrayList<>();
        addPosition(initialPosition);
    }

    public static PositionLog from(int initialPosition) {
        return new PositionLog(initialPosition);
    }

    public int size() {
        return positions.size();
    }

    public List<Integer> getContent() {
        return Collections.unmodifiableList(positions);
    }

    private void addPosition(int position) {
        positions.add(position);
    }

    public void moveDown(LadderLines lines) {
        List<LadderLine> lineList = lines.getContent();

        for (LadderLine ladderLine : lineList) {
            moveDown(ladderLine);
        }
    }

    private void moveDown(LadderLine line) {
        int newPosition = line.moveDownFrom(getLastPosition());
        addPosition(newPosition);
    }

    public int getLastPosition() {
        return positions.get(size() - 1);
    }
}
