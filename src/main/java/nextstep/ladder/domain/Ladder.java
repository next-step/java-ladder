package nextstep.ladder.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public static Ladder createLadder(int countOfUsers, int height, BridgeStrategy strategy) {
        return new Ladder(countOfUsers, height, strategy);
    }

    private Ladder(int countOfUsers, int height, BridgeStrategy strategy) {
        for (int i = 0; i < height; i++) {
            Line line = Line.createLine(countOfUsers, strategy);
            lines.add(line);
        }
    }

    public String status() {
        String result = "";
        int height = lines.size();
        for (int i = 0; i < height; i++) {
            Line line = lines.get(i);
            result += line.status();
        }
        return result;
    }

    public int findLastPosition(int position) {
        if (lines.isEmpty()) {
            return position;
        }

        int currentPosition = position;
        for (Line line : lines) {
            currentPosition = line.getNextPosition(currentPosition);
        }
        return currentPosition;
    }
}
