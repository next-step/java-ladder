package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private static final String LINE_SEPERATOR = "\n";
    private static final String CONNECTED = "|-----";
    private static final String DISCONNECTED = "|     ";
    public static final int ODD_LINE = 0;
    public static final int ODD_NUMBER_LINE = ODD_LINE;

    private final List<Line> lines;

    public Lines(int numberOfPlayers) {
        this.lines = createLines(numberOfPlayers);
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    private List<Line> createLines(int numberOfPlayers) {
        return IntStream.rangeClosed(1, numberOfPlayers)
                .mapToObj(i -> new Line())
                .collect(Collectors.toList());
    }

    public void generateConnections(ConnectCondition oddCondition, ConnectCondition evenCondition) {
        generateConnectionsExceptLastLine(oddCondition, evenCondition);
    }

    private void generateConnectionsExceptLastLine(ConnectCondition oddCondition, ConnectCondition evenCondition) {
        for (int i = 0; i < lines.size() - 1; i++) {
            generateEachConnectionsExceptLastLine(lines.get(i), oddCondition, evenCondition);
        }
    }

    private void generateEachConnectionsExceptLastLine(Line line, ConnectCondition oddCondition,
                                                       ConnectCondition evenCondition) {
        int index = lines.indexOf(line);
        if (index % 2 == ODD_NUMBER_LINE) {
            connectionConditionSatisfyAboutFortyPercent(line, index, oddCondition);
            return;
        }
        connectionConditionSatisfyAboutFortyPercent(line, index, evenCondition);
    }

    private void connectionConditionSatisfyAboutFortyPercent(Line line, int index, ConnectCondition connectCondition) {
        if (connectCondition.test(line)) {
            Line nextLine = lines.get(index + 1);
            line.connectRight();
            nextLine.connectLeft();
        }
    }

    public String getLinesState() {
        return "     " + lines.stream()
                .map(this::getConnectionsState)
                .collect(Collectors.joining()) + LINE_SEPERATOR;
    }

    private String getConnectionsState(Line line) {
        if (line.isRightConnected()) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public Line getLineOfSpecificLocation(int i) {
        return lines.get(i);
    }

    public int getLineCount() {
        return lines.size();
    }

}
