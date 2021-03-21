package ladder.view;

import ladder.dto.LadderGameResult;
import ladder.dto.LadderResultDto;

import java.util.List;

public class ResultView {

    public static final String EMPTY_POINT_REPRESENTATION = "     ";

    public static final String FILLED_POINT_REPRESENTATION = "-----";

    public static final String VERTICAL_LINE_REPRESENTATION = "|";

    private static final int FIXED_SPACE = 6;

    private static final String NAME_AND_PRIZE_SEPARATOR = ":";

    public static void printLadderBoard(LadderResultDto ladderResultDto) {
        System.out.println(MessageConstant.LADDER_RESULT);
        printPlayerNameList(ladderResultDto.playerNameList());
        System.out.println(ladderResultDto.ladderLine());
        printPrizeNameList(ladderResultDto.prizeNameList());
    }

    private static void printPlayerNameList(List<String> playerNameList) {
        playerNameList.stream()
                .map(playerName -> String.format("%" + FIXED_SPACE + "." + FIXED_SPACE + "s", playerName))
                .forEach(System.out::print);
        printEmptyLine();
    }

    private static void printPrizeNameList(List<String> prizeNameList) {
        prizeNameList.stream()
                .map(prizeName -> String.format("%" + FIXED_SPACE + "." + FIXED_SPACE + "s", prizeName))
                .forEach(System.out::print);
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }


    public static void printResult(List<LadderGameResult> gameResultList) {
        System.out.println(MessageConstant.GAME_RESULT);
        gameResultList.stream()
                .map(gameResult ->
                        String.format("%s"+ NAME_AND_PRIZE_SEPARATOR + "%s", gameResult.playerName(),gameResult.prizeName()))
                .forEach(System.out::println);
    }
}

