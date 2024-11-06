package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
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

    public void generateConnections() {
        Random random = new Random();
        generateConnectionsExceptLastLine(random);
    }

    private void generateConnectionsExceptLastLine(Random random) {
        for (int i = 0; i < lines.size() - 1; i++) {
            generateEachConnectionsExceptLastLine(random, lines.get(i), i);
        }
    }

    private void generateEachConnectionsExceptLastLine(Random random, Line line, int i) {
        if (connectionConditionSatisfyAboutFortyPercent(random, line, i)) {
            Line nextLine = lines.get(i + 1);
            line.connectRight();
            nextLine.connectLeft();
        }
    }

    private static boolean connectionConditionSatisfyAboutFortyPercent(Random random, Line line, int number) {
        if (number % 2 == ODD_NUMBER_LINE) {
            return random.nextInt(10) > 5 && !line.isLeftConnected();
        }
        return random.nextInt(10) > 2 && !line.isLeftConnected();
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
