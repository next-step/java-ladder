package ladder.view;

import ladder.domain.dto.LadderShapeResult;
import ladder.domain.dto.StairDto;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String PLAYER_NAMES_INFO_FORMAT = "%6s";
    private static final String PILLAR_MARK = "|";
    private static final String STAIR_MARK = "-----";
    private static final String EMPTY_STAIR_MARK = "     ";

    private ResultView() {
    }

    public static void printResult(LadderShapeResult result) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        printPlayerNames(result.getPlayerNames());
        printLadderShape(result.getStairDtos());
    }

    private static void printPlayerNames(final List<String> names) {
        names.forEach(name -> System.out.print(String.format(PLAYER_NAMES_INFO_FORMAT, name)));
        System.out.println();
    }

    private static void printLadderShape(final List<StairDto> stairDtos) {
        stairDtos.forEach(stairDto -> {
            System.out.print(EMPTY_STAIR_MARK);
            stairDto.getLines().forEach(existLine -> System.out.print(getOnePieceOfLadderShape(existLine)));
            System.out.println();
        });
    }

    private static String getOnePieceOfLadderShape(final boolean existLine) {
        if (existLine) {
            return PILLAR_MARK + STAIR_MARK;
        }
        return PILLAR_MARK + EMPTY_STAIR_MARK;
    }
}
