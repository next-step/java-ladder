package ladderGame.view;

import ladderGame.domain.*;
import ladderGame.dto.GameInformation;
import ladderGame.dto.ResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String DELIMITER = " : ";
    private static final boolean PRINT_SUCCESS = true;
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String PLAYER_PRINT_INTERVAL = "\t";
    private static final String MARGIN = "   ";
    private static final String EMPTY_RUNG = "|     ";
    private static final String RUNG = "|-----";


    public static void drawLadderAndPlayer(Ladder ladder, GameInformation gameInformation) {
        System.out.println(RESULT_MESSAGE);
        drawPlayers(gameInformation.getPlayers());
        drawLadder(ladder);
        drawResult(gameInformation.getLadderResults());
    }

    private static void drawResult(LadderResults ladderResults) {
        String resultContens = ladderResults.getLadderResults().stream()
                .map(LadderResult::getContent)
                .collect(Collectors.joining(PLAYER_PRINT_INTERVAL));
        System.out.println(resultContens);
    }

    private static void drawPlayers(Players players) {
        String playersName = players.getPlayers().stream()
                .map(Player::getName)
                .collect(Collectors.joining(PLAYER_PRINT_INTERVAL));
        System.out.println(playersName);
    }

    private static void drawLadder(Ladder ladder) {
        ladder.getDirectionLayers()
                .forEach(layer -> System.out.println(MARGIN + printLayer(layer)));
    }

    private static String printLayer(DirectionLayer directionLayer) {
        return directionLayer.getDirectionsByPosition().stream()
                .map(ResultView::drawGameRung)
                .collect(Collectors.joining());
    }

    private static String drawGameRung(Direction direction) {
        if (direction == Direction.RIGHT) {
            return RUNG;
        }
        return EMPTY_RUNG;
    }

    public static boolean printOne(ResultDto resultDto) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(resultDto.getContent());
        return PRINT_SUCCESS;
    }

    public static Boolean printAll(List<ResultDto> ladderResult) {
        System.out.println(RESULT_MESSAGE);
        ladderResult.forEach(result -> System.out.println(result.getName() + DELIMITER + result.getContent()));
        return PRINT_SUCCESS;
    }
}

