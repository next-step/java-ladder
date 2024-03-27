package nextstep.ladder.view;

import nextstep.ladder.dto.LadderResult;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Player;
import nextstep.ladder.model.Point;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PIPE_LINE = "|";
    private static final String LINE = "-----";
    private static final String THREE_BLANK = "   ";
    private static final String FIVE_BLANK = "     ";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String ALL = "all";
    private static final String NOT_FOUND_NAME = "";

    public void print(List<Player> players, Ladder ladder, List<String> rewards) {
        StringBuilder sb = new StringBuilder();
        sb.append("사다리 결과").append(NEW_LINE);

        appendNames(sb, players);
        appendLadder(sb, ladder);
        appendRewards(sb, rewards);

        System.out.println(sb);
    }

    private void appendNames(StringBuilder sb, List<Player> players) {
        sb.append(THREE_BLANK);
        players.stream().map(Player::getName).forEach(name -> {
            sb.append(String.format("%-6s", name));
        });
        sb.append(NEW_LINE);
    }

    private void appendLadder(StringBuilder sb, Ladder ladder) {
        List<Line> lines = ladder.getLines();

        lines.stream()
                .map(Line::getPoints)
                .forEach(points -> this.appendLine(sb, points));
    }

    private void appendLine(StringBuilder sb, List<Point> points) {
        sb.append(FIVE_BLANK).append(PIPE_LINE);

        for (int i = 1; i < points.size(); i++) {
            sb.append(points.get(i).isConnected() ? LINE : FIVE_BLANK).append(PIPE_LINE);
        }

        sb.append(NEW_LINE);
    }

    private void appendRewards(StringBuilder sb, List<String> rewards) {
        sb.append(THREE_BLANK);
        rewards.forEach(result -> {
            sb.append(String.format("%-6s", result));
        });
        sb.append(NEW_LINE);
    }

    public void printResultBy(LadderResult ladderResult, String name) {
        if (ALL.equals(name)) {
            printAll(ladderResult);
            return;
        }

        printOnlyOne(ladderResult, name);
    }

    private void printAll(LadderResult ladderResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과").append(NEW_LINE);

        Map<String, String> nameAndRewardMap = ladderResult.getNameAndRewardMap();
        nameAndRewardMap.keySet().forEach(name -> {
            String text = String.format("%s : %s", name, nameAndRewardMap.get(name));
            sb.append(text).append(NEW_LINE);
        });

        System.out.println(sb);
    }

    private void printOnlyOne(LadderResult ladderResult, String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과").append(NEW_LINE);

        Map<String, String> nameAndRewardMap = ladderResult.getNameAndRewardMap();
        sb.append(nameAndRewardMap.getOrDefault(name, NOT_FOUND_NAME));

        System.out.println(sb);
    }
}
