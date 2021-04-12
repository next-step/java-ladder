package ladder;

import java.util.List;
import java.util.Optional;

public class ResultView {
    public static final String INIT_INDENT = "    ";

    private final Players players;
    private final List<LineResult> lineResults;

    public ResultView(Players players, List<LineResult> lineResults) {
        this.players = players;
        this.lineResults = lineResults;
    }

    public void printOutLineResult() {
        for (LineResult lineResult : lineResults) {
            StringBuilder line = new StringBuilder(INIT_INDENT);
            for (PointResult pointResult : lineResult.getPointResults()) {
                String result = "";
                result = result.concat(printOfDirection(pointResult.getDirection()));
                result = printOfPosition(pointResult.getPosition(), result);
                line.append(result);
            }
            System.out.println(line);
        }
    }

    public void printOutPlayers() {
        Optional.of(players)
                .map(Players::allPlayers)
                .orElseThrow(IllegalArgumentException::new)
                .forEach(player -> System.out.print(padLeft(player.getName()) + " "));
    }

    private String printOfDirection(Direction direction) {
        String printString = "--|---";
        if (direction.equals(Direction.RIGHT)) {
            return printString.replace("--|", "  |");
        }

        if (direction.equals(Direction.LEFT)) {
            return printString.replace("|---", "|   ");
        }

        if (direction.equals(Direction.NO_DIRECTION)) {
            return printString.replace("-", " ");
        }
        throw new IllegalArgumentException("일치하는 방향이 존재하지 않습니다.");
    }

    private String printOfPosition(Position position, String inputString) {
        if (position.equals(Position.FIRST)) {
            return inputString.replace("  |", "|");
        }
        if (position.equals(Position.LAST)) {
            return inputString.replace("|   ", "|");
        }
        return inputString;
    }

    private String padLeft(String inputString) {
        return String.format("%1$" + Player.MAX_SIZE + "s", inputString);
    }
}
