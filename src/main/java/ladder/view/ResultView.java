package ladder.view;

import ladder.domain.dto.LadderMatchResult;
import ladder.domain.dto.LadderShapeResult;
import ladder.domain.dto.StairDto;
import ladder.domain.player.Player;
import ladder.domain.prize.Prize;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "사다리 결과";
    private static final String NAMES_INFO_FORMAT = "%6s";
    private static final String PILLAR_MARK = "|";
    private static final String STAIR_MARK = "-----";
    private static final String EMPTY_STAIR_MARK = "     ";
    private static final String MATCH_RESULT_MESSAGE = "실행 결과";
    private static final String ALL_PLAYERS = "all";
    private static final String PLAYER_AND_PRIZE_FORMAT = "%s : %s";

    private ResultView() {
    }

    public static void printLadderShape(LadderShapeResult result) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        printNames(result.getPlayerNames());
        printLadderShape(result.getStairDtos());
        printNames(result.getPrizeNames());
    }

    private static void printNames(final List<String> names) {
        names.forEach(name -> System.out.print(String.format(NAMES_INFO_FORMAT, name)));
        System.out.println();
    }

    private static void printLadderShape(final List<StairDto> stairDtos) {
        stairDtos.forEach(ResultView::printStairDto);
    }

    private static void printStairDto(final StairDto stairDto) {
        System.out.print(EMPTY_STAIR_MARK);

        stairDto.getLines()
                .forEach(existLine -> System.out.print(getOnePieceOfLadderShape(existLine)));
        System.out.println();
    }

    private static String getOnePieceOfLadderShape(final boolean existLine) {
        if (existLine) {
            return PILLAR_MARK + STAIR_MARK;
        }
        return PILLAR_MARK + EMPTY_STAIR_MARK;
    }

    public static void printResult(final LadderMatchResult ladderMatchResult, final String targetPlayerName) {
        System.out.print(MATCH_RESULT_MESSAGE);
        System.out.println();

        if (targetPlayerName.equalsIgnoreCase(ALL_PLAYERS)) {
            ladderMatchResult.getPlayers()
                    .forEach(player -> printPlayerAndPrizeMatchResult(player, ladderMatchResult.match(player.getName())));
            return;
        }
        printPrizeMatchResult(ladderMatchResult.match(targetPlayerName));
    }

    private static void printPlayerAndPrizeMatchResult(final Player player, final Prize prize) {
        System.out.println(String.format(PLAYER_AND_PRIZE_FORMAT, player.getName(), prize.getName()));
    }

    private static void printPrizeMatchResult(final Prize prize) {
        System.out.println(prize.getName());
    }
}
