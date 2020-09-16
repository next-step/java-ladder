package laddergame.domain.line;

import laddergame.domain.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Line {

    private List<Boolean> line;

    public Line(int ladderWidth, Connention probability) {
        line = new ArrayList<>();
        IntStream.range(Constants.COUNT_ZERO, ladderWidth)
                .forEach(index -> makeConnections(index, probability));
    }

    private void makeConnections(int index, Connention connention) {
        if (index == Constants.COUNT_ZERO) {
            line.add(connention.successConnect());
            return;
        }

        boolean previousConnection = line.get(index - Constants.COUNT_ONE);
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