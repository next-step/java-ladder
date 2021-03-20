package ladder.view;

import ladder.dto.LadderBoard;

import java.util.List;

public class ResultView {

    public static final String EMPTY_POINT_REPRESENTATION = "     ";

    public static final String FILLED_POINT_REPRESENTATION = "-----";

    public static final String VERTICAL_LINE_REPRESENTATION = "|";

    private static final int FIXED_PLAYER_NAME_SPACE = 6;

    public static void printLadderBoard(LadderBoard ladderBoard) {
        System.out.println(MessageConstant.GAME_RESULT);
        printPlayerNameList(ladderBoard.playerNameList());
        System.out.println(ladderBoard.lineListToString());
    }

    private static void printPlayerNameList(List<String> playerNameList) {
        playerNameList.stream()
                .map(playerName -> String.format("%" + FIXED_PLAYER_NAME_SPACE + "." + FIXED_PLAYER_NAME_SPACE + "s", playerName))
                .forEach(System.out::print);
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }


}

