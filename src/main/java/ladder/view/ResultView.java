package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Name;
import ladder.domain.Players;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static final int START_INCLUSIVE = 0;
    public static final String LINE_BREAK = "\n";
    public static final String SPACE = " ";
    public static final String HORIZONTAL = "-";
    public static final String PLAYER_DELIMITER = "|";
    public static final String PREFIX = "";
    public ResultView() {
    }

    public void renderLadder(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println(toLadderString(ladder));
    }

    public String toLadderString(Ladder ladder) {
        Players players = ladder.getPlayers();
        List<Line> lines = ladder.getLines().getLines();
        String namesString = players.names()
                .stream()
                .map(name -> SPACE.repeat(players.namesMaxLength() - name.length()) + name.name())
                .collect(Collectors.joining(SPACE));
        String linesString = lines.stream()
                .map(line -> toLineString(players, line.getPoint()))
                .collect(Collectors.joining(LINE_BREAK));
        return namesString + LINE_BREAK + linesString;
    }

    public String toLineString(Players players, List<Boolean> point) {
        List<Name> names = players.names();
        int namesMaxLength = players.namesMaxLength();
        return IntStream.range(START_INCLUSIVE, names.size())
                .boxed()
                .map(index -> toHorizontalString(index, namesMaxLength, point))
                .collect(Collectors.joining(PLAYER_DELIMITER, PREFIX, PLAYER_DELIMITER));
    }

    private String toHorizontalString(int index, int length, List<Boolean> point) {
        if (point.get(index)) {
            return HORIZONTAL.repeat(length);
        }
        return SPACE.repeat(length);
    }
}
