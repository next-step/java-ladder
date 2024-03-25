package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Name;
import nextstep.ladder.model.Player;

import java.util.List;

public class OutputView {

    private static final String PIPE_LINE = "|";
    private static final String LINE = "-----";
    private static final String THREE_BLANK = "   ";
    private static final String FIVE_BLANK = "     ";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String ALL = "all";

    public void print(List<Player> players, Ladder ladder, List<String> ladderReward) {
        StringBuilder sb = new StringBuilder();
        sb.append("사다리 결과").append(NEW_LINE);

        appendNames(sb, players);
        appendLadder(sb, ladder);
        appendLadderReward(sb, ladderReward);

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

    private void appendLine(StringBuilder sb, List<Boolean> points) {
        sb.append(FIVE_BLANK).append(PIPE_LINE);
        points.forEach(point -> {
            sb.append(point ? LINE : FIVE_BLANK).append(PIPE_LINE);
        });
        sb.append(NEW_LINE);
    }

    private void appendLadderReward(StringBuilder sb, List<String> ladderReward) {
        sb.append(THREE_BLANK);
        ladderReward.forEach(result -> {
            sb.append(String.format("%-6s", result));
        });
        sb.append(NEW_LINE);
    }

    public void printResultBy(List<String> ladderResult, List<Player> playerResult, String name) {
        if (ALL.equals(name)) {
            printAll(ladderResult, playerResult);
            return;
        }

        printOnlyOne(ladderResult, playerResult, name);
    }

    private void printAll(List<String> ladderResult, List<Player> playerResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과").append(NEW_LINE);

        playerResult.forEach(player -> {
            String text = String.format("%s : %s", player.getName(), ladderResult.get(player.getPosition()));
            sb.append(text).append(NEW_LINE);
        });

        System.out.println(sb);
    }

    private void printOnlyOne(List<String> ladderResult, List<Player> playerResult, String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과").append(NEW_LINE);
        sb.append(ladderResult.get(findFinalPosition(playerResult, name)));
        System.out.println(sb);
    }

    private int findFinalPosition(List<Player> playerResult, String name) {
        Name target = new Name(name);

        return playerResult.stream()
                .filter(player -> player.sameName(target))
                .map(Player::getPosition)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참가자 중에 " + name + "이 존재하지 않습니다"));
    }
}
