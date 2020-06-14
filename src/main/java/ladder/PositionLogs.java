package ladder;

import java.util.Collections;
import java.util.List;

public class PositionLogs {

    private final List<PositionLog> positionLogs;

    private PositionLogs(List<PositionLog> positionLogs) {
        this.positionLogs = positionLogs;
    }

    public static PositionLogs of(List<PositionLog> logs) {
        return new PositionLogs(logs);
    }

    public int size() {
        return positionLogs.size();
    }

    public List<PositionLog> getContent() {
        return Collections.unmodifiableList(positionLogs);
    }

    public void moveDown(LadderLines lines) {
        for (PositionLog log : positionLogs) {
            log.moveDown(lines);
        }
    }

    public int getLastPosition(int initialPosition) {
        return positionLogs.get(initialPosition).getLastPosition();
    }
}
