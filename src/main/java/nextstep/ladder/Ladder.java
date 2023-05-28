package nextstep.ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Height height;
    private final int vertical;
    private final List<Line> lines;

    public Ladder(int height, int countOfVerticalLine) {
        this(height, countOfVerticalLine, new RandomLineStrategy());
    }

    public Ladder(int height, int countOfVerticalLine, LineStrategy lineStrategy) {
        this.height = new Height(height);
        this.vertical = countOfVerticalLine;
        this.lines = drawLine(height, countOfVerticalLine, lineStrategy);
    }

    private List<Line> drawLine(int height, int countOfVerticalLine, LineStrategy lineStrategy) {
        return IntStream.range(0, height)
                .mapToObj(h -> new Line(countOfVerticalLine, lineStrategy))
                .collect(Collectors.toList());
    }

    public Map<String, String> start(Participant participant, LadderResult ladderResult) {
        int arrivedVerticalIndex = 0;
        Map<String, String> gameResult = new HashMap<>();

        for (int startVerticalIndex = 0; startVerticalIndex < vertical; startVerticalIndex++) {
            arrivedVerticalIndex = moveToGoal(startVerticalIndex);
            gameResult.put(participant.getParticipant(startVerticalIndex), ladderResult.getResult(arrivedVerticalIndex));
        }
        return gameResult;
    }

    public boolean isRightCondition(Participant participant, LadderResult result) {
        return participant.isSameSize(vertical) && result.isSameSize(vertical);
    }

    private int moveToGoal(int verticalIndex) {
        for (int j = 0; j < lines.size(); j++) {
            Line line = lines.get(j);
            verticalIndex = line.move(verticalIndex);
        }
        return verticalIndex;
    }

    public int getHeight() {
        return height.height();
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getLineSize() {
        return lines.size();
    }


}
