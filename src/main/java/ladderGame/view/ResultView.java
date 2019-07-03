package ladderGame.view;

import ladderGame.domain.*;

import java.util.stream.Collectors;

public class ResultView {

    private static final String PLAYER_PRINT_INTERVAL = "\t";
    private static final String MARGIN = "   ";
    private static final String EMPTY_RUNG = "|     ";
    private static final String RUNG = "|-----";


    public static void drawLadderAndPlayer(Players players, Ladder ladder) {
        System.out.println("실행 결과");
        drawPlayers(players);
        drawLadder(ladder);
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
        return directionLayer.getDirections().stream()
                .map(ResultView::drawGameRung)
                .collect(Collectors.joining());
    }

    private static String drawGameRung(Direction direction) {
        if(direction == Direction.RIGHT) {
            return RUNG;
        }
        return EMPTY_RUNG;
    }
}

