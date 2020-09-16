package laddergame.domain.line;

import laddergame.domain.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> line;

    public Line(int ladderWidth, Connention probability) {
        line = new ArrayList<>();

        for (int i = 0; i < ladderWidth; i++) {
            makeConnections(probability);
        }
    }

    private void makeConnections(Connention connention) {
        if (line.isEmpty()) {
            line.add(connention.successConnect());
            return;
        }

        boolean previousConnection = line.get(Constants.LAST_ELEMENT_INDEX(line.size()));
        if (previousConnection) {
            line.add(false);
            return;
        }

        line.add(connention.successConnect());
    }

    public List<Boolean> getLine() {
        return line;
    }
}