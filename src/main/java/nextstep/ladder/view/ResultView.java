package nextstep.ladder.view;

import nextstep.ladder.domain.Board;
import nextstep.ladder.domain.BoardConsumer;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.winningPrize.WinningPrize;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String REQUEST_PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_WINNING_PRIZE_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String REQUEST_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String REQUEST_PLAYER_NAME_FOR_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String LADDER_SHAPE_MESSAGE = "사다리 결과\n";
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void requestPlayerNames() {
        System.out.println(REQUEST_PLAYER_NAME_MESSAGE);
    }

    public static void requestWinningPrizes() {
        System.out.println(REQUEST_WINNING_PRIZE_MESSAGE);
    }


    public static void requestLadderHeight() {
        System.out.println(REQUEST_LADDER_HEIGHT_MESSAGE);
    }

    public static void printLadderShape(BoardConsumer boardConsumer, Board board) {
        System.out.println(LADDER_SHAPE_MESSAGE);

        System.out.println(boardConsumer.getPlayers().stream()
                .map(Player::toString)
                .collect(Collectors.joining(" ")));
        System.out.println(board);
        System.out.println(boardConsumer.getWinningPrizes().stream()
                .map(WinningPrize::toString)
                .collect(Collectors.joining(" ")));
    }

    public static void printResult(Map<Integer, Integer> playerResult, BoardConsumer boardConsumer, List<Player> players) {
        System.out.println(RESULT_MESSAGE);

        List<WinningPrize> winningPrizes = players.stream()
                .map(boardConsumer::getPlayerIndex)
                .map(playerResult::get)
                .map(boardConsumer::getWinningPrize)
                .collect(Collectors.toList());

        if (winningPrizes.size() == 1) {
            System.out.println(winningPrizes.get(0));
            return;
        }
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i) + " : " + winningPrizes.get(i));
        }
        if (playerResult.size() == players.size()) {
            System.exit(0);
        }
    }

    public static void requestPlayerNameForResult() {
        System.out.println(REQUEST_PLAYER_NAME_FOR_RESULT_MESSAGE);
    }

    public static String parseBooleanToDot(boolean input) {
        if (input) {
            return "-----|";
        }
        return "     |";
    }
}
