package ladder.view;

import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.LadderReward;

import java.util.List;

public class ResultView {

    private static final String HORIZONTAL_LINE = "-----";
    private static final String SPACE_HORIZONTAL_LINE = "     ";
    private static final String SPACE_START_HORIZONTAL_LINE = "    ";
    private static final String VERTICAL_LINE = "|";
    private static final String NAME_LENGTH_FIVE_FORMAT_PATTERN = "%5s";
    private static final String RESULT_TEXT = "실행결과";
    private static final String LADDER_COMPLETE_TEXT = "사다리 결과";

    public ResultView() {}

    public void printResult(List<Player> players, List<Line> lines, List<LadderReward> ladderRewards) {
        printResultText();
        printPlayerName(players);
        printLadderLine(lines);
        printLadderResult(ladderRewards);
    }

    private void printResultText() {
        System.out.println(LADDER_COMPLETE_TEXT);
    }

    private void printPlayerName(List<Player> players) {
        StringBuilder sb = new StringBuilder();

        players.stream()
                .map(Player::getName)
                .forEach(name -> sb.append(String.format(NAME_LENGTH_FIVE_FORMAT_PATTERN, name)).append(" "));

        System.out.println(sb.toString());
    }

    private void printLadderLine(List<Line> lines) {
        lines.forEach(line -> System.out.println(getLineText(line.getPoints())));
    }

    private String getLineText(List<Boolean> points) {
        StringBuilder sb = new StringBuilder();

        sb.append(SPACE_START_HORIZONTAL_LINE);
        points.forEach(hasHorizontalLine -> addHorizontalLine(sb, hasHorizontalLine));
        sb.append(VERTICAL_LINE);

        return sb.toString();
    }

    private void addHorizontalLine(StringBuilder sb, boolean hasHorizontalLine) {
        sb.append(VERTICAL_LINE);
        if (hasHorizontalLine) {
            sb.append(HORIZONTAL_LINE);
        }
        if (!hasHorizontalLine) {
            sb.append(SPACE_HORIZONTAL_LINE);
        }
    }

    private void printLadderResult(List<LadderReward> ladderRewards) {
        StringBuilder sb = new StringBuilder();

        ladderRewards.stream()
                .map(LadderReward::getReward)
                .forEach(name -> sb.append(String.format(NAME_LENGTH_FIVE_FORMAT_PATTERN, name)).append(" "));

        System.out.println(sb.toString());
    }
}
