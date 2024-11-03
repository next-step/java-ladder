package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private static final String LINE_SEPERATOR = "\n";
    private static final String CONNECTED = "-----|";
    private static final String DISCONNECTED = "     |";

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

    private void generateEachConnectionsExceptLastLine(Random random, int i) {
        Line line = lines.get(i);
        if(connectionConditionSatisfyAboutFortyPercent(random, line, i)) {
            Line nextLine = lines.get(i +1);
            line.connectRight();
            nextLine.connectLeft();
        }
    }

    private void generateConnectionsExceptLastLine(Random random) {
        for (int i = 1 ; i<lines.size() -1 ; i++) {
            generateEachConnectionsExceptLastLine(random, i);
        }
    }

    private static boolean connectionConditionSatisfyAboutFortyPercent(Random random, Line line, int number) {
        if(number%2==1) {
            return random.nextInt(10)>5 && !line.isLeftConnected();
        }
        return random.nextInt(10)>2 && !line.isLeftConnected();
    }

    private void generationLastLineConnection(Random random) {
        Line lastLine = lines.get(lines.size()-1);
        if(connectionConditionSatisfyAboutFortyPercent(random, lastLine, lines.size()-1)) {
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
