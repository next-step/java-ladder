package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladderGame.LadderGameInfo;
import nextstep.ladder.domain.ladderGame.LadderGameResult;
import nextstep.ladder.domain.ladderGame.LadderReward;
import nextstep.ladder.domain.ladderGame.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LADDER_MESSAGE = "사다리 결과\n";
    private static final String NAME_FORMAT = "%5s";
    private static final String NAME_DELIMiTER = " ";
    private static final String NODE = "|";
    private static final String EMPTY = "";
    private static final String LINK_CONNECT = "-----";
    private static final String LINK_DIS_CONNECT = "     ";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String TARGET_ALL = "all";

    public static void print(Ladder ladder, LadderGameInfo ladderGameInfo) {
        System.out.println(LADDER_MESSAGE);
        printPlayer(ladderGameInfo.getPlayers());
        printLadderLines(ladder.getLines());
        printLadderRewards(ladderGameInfo.getLadderRewards());
    }

    private static void printPlayer(List<Player> players) {
        System.out.println(players.stream()
                .map(player -> String.format(NAME_FORMAT, player.toString()))
                .collect(Collectors.joining(NAME_DELIMiTER)));
    }

    private static void printLadderLines(List<Line> lines) {
        lines.forEach(ResultView::printLadderLine);
    }

    private static void printLadderLine(Line line) {
        System.out.println(line.getPoints()
                .stream()
                .map(point -> point.getDirection().isLeft() ? LINK_CONNECT : LINK_DIS_CONNECT)
                .collect(Collectors.joining(NODE, EMPTY, NODE)));
    }

    private static void printLadderRewards(List<LadderReward> ladderRewards) {
        System.out.println(ladderRewards.stream()
                .map(reward -> String.format(NAME_FORMAT, reward.toString()))
                .collect(Collectors.joining(NAME_DELIMiTER)));
    }

    public static void printResult(String inputTarget, LadderGameResult result) {
        System.out.println(RESULT_MESSAGE);
        if (TARGET_ALL.equals(inputTarget)) {
            result.getResults().forEach((player, reward)
                    -> System.out.println(String.format(RESULT_FORMAT, player.toString(), reward.toString())));
            return;
        }
        System.out.println(result.getLadderReward(inputTarget));
    }
}
