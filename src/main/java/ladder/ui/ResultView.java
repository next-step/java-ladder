package ladder.ui;

import ladder.domain.game.LadderGameResults;
import ladder.domain.game.LadderReward;
import ladder.domain.game.LadderRewards;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Lines;
import ladder.domain.ladder.Point;
import ladder.domain.player.LadderPlayer;
import ladder.domain.player.LadderPlayers;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class ResultView {

    private static final String LADDER_MESSAGE = "사다리 결과\n";
    private static final String NAME_FORMAT = "%5s";
    private static final String NAME_DELIMiTER = " ";
    private static final String NODE = "|";
    private static final String EMPTY = "";
    private static final String LINE_CONNECT = "-----";
    private static final String LINE_DIS_CONNECT = "     ";
    private static final String RESULT_REQUEST = "결과를 보고 싶은 사람은?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RESULT_FORMAT = "%s : %s";

    public static void print(Lines lines, LadderPlayers ladderPlayers, LadderRewards ladderRewards) {
        System.out.println(LADDER_MESSAGE);
        printLadderPlayer(ladderPlayers.getLadderPlayers());

        printLines(lines.getLineList());
        printLadderRewards(ladderRewards.getLadderRewards());
    }

    private static void printLadderPlayer(List<LadderPlayer> ladderPlayers) {
        System.out.println(ladderPlayers.stream()
                .map(ladderPlayer -> String.format(NAME_FORMAT, ladderPlayer.getPlayerName()))
                .collect(Collectors.joining(NAME_DELIMiTER)));
    }

    private static void printLines(List<Line> lines) {
        lines.forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        System.out.println(line.getPoints()
                .stream()
                .map(point -> point.getPointDirection().isLeft() ? LINE_CONNECT : LINE_DIS_CONNECT)
                .collect(Collectors.joining(NODE, EMPTY, NODE)));
    }

    private static void printLadderRewards(List<LadderReward> ladderRewards) {
        System.out.println(ladderRewards.stream()
                .map(reward -> String.format(NAME_FORMAT, reward.getReward()))
                .collect(Collectors.joining(NAME_DELIMiTER)));
    }

    public static void printResult(String inputTarget, LadderGameResults results) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(results.getLadderReward(inputTarget));
    }

    public static void printAllResult(LadderGameResults results) {
        System.out.println(RESULT_REQUEST);
        results.getResults().forEach((user, reward)
                -> System.out.println(String.format(RESULT_FORMAT,user.toString(),reward.toString())));
    }
}
