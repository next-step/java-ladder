package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Connection> lines;

    public Bridge() {
        lines = new ArrayList<>();
    }

    public void connectSteps(int participantCount, ConnectionStrategy strategy) {
        for (int index = 0; index < participantCount-1; index++) {
            checkAndConnectLines(index, strategy.isConnect());
        }
    }

    private void checkAndConnectLines(int index, boolean isConnect) {
        if (index > 0 && lines.get(index-1).isConnect()) {
            Connection.connect(lines, false);
            return;
        }

       Connection.connect(lines, isConnect);
    }

    public Position move(Position position) {
        if (position.getValue() > 0 && lines.get(position.getValue()-1).isConnect()) {
            return position.moveLeft();
        }

        if (position.getValue() < lines.size() && lines.get(position.getValue()).isConnect()) {
            return position.moveRight();
        }

        return position;
    }

    public List<Connection> getLines() {
        return lines;
    }

}
