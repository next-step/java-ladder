package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.VerticalLine.createVerticalLines;

public class LadderGame {
    private final Users participants;
    private final List<VerticalLine> verticalLines;

    public LadderGame(Users participants, Height height) {
        this.participants = participants;
        this.verticalLines = createVerticalLines(participants.size(), height);
    }

    public LadderGame(List<String> participants, int height) {
        this(new Users(participants), new Height(height));
    }


    public int width() {
        return participants.size();
    }

    public int height() {
        return verticalLines.get(0).height();
    }

    public void drawAll(DrawStrategy drawStrategy) {
        for (int i = 0; i < width() - 1; i++) {
            drawLine(i, drawStrategy);
        }
    }

    private void drawLine(int indexOfLine, DrawStrategy drawStrategy) {
        verticalLines.get(indexOfLine).drawLine(verticalLines.get(indexOfLine + 1), drawStrategy);
    }

    public List<Integer> connectedCounts() {
        return verticalLines.stream()
                .map(VerticalLine::connectedCount)
                .collect(Collectors.toList());
    }

    public List<Boolean> checkRightConnections(int index) {
        return IntStream.range(0, width())
                .mapToObj(i -> verticalLines.get(i).checkRightConnection(index))
                .collect(Collectors.toList());
    }

    public List<String> getParticipants() {
        return IntStream.range(0, width())
                .mapToObj(participants::getUserName)
                .collect(Collectors.toList());
    }
}
