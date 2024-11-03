package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private static final String LINE_SEPERATOR = "\n";
    public static final String CONNECTED = "-----|";
    public static final String DISCONNECTED = "     |";
    private final List<Line> lines;

    public Lines(int numberOfPlayers) {
        this.lines = createLines(numberOfPlayers);
    }

    private List<Line> createLines(int numberOfPlayers) {
        return  IntStream.rangeClosed(1, numberOfPlayers)
                .mapToObj(i -> new Line())
                .collect(Collectors.toList());
    }

    public void generateConnections() {
        Random random = new Random();
        generateConnectionsExceptLastLine(random);
        generationLastLineConnection(random);
    }

    private void generateConnectionsExceptLastLine(Random random) {
        for (int i = 1 ; i<lines.size() -1 ; i++) {
            generateEachConnectionsExceptLastLine(random, i);
        }
    }

    private void generateEachConnectionsExceptLastLine(Random random, int i) {
        Line line = lines.get(i);
        if(connectionCondition(random, line)) {
            Line nextLine = lines.get(i +1);
            line.connectRight();
            nextLine.connectLeft();
        }
    }

    private static boolean connectionCondition(Random random, Line line) {
        return random.nextBoolean() && !line.isLeftConnected();
    }

    private void generationLastLineConnection(Random random) {
        Line lastLine = lines.get(lines.size()-1);
        if(connectionCondition(random, lastLine)) {
            lastLine.connectRight();
        }
    }

    public String getLinesState() {
        return lines.stream()
                .map(this::getConnectionsState)
                .collect(Collectors.joining()) + LINE_SEPERATOR;
    }

    private String getConnectionsState(Line line) {
        if(line.isRightConnected()) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

}
