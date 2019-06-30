package ladderGame.view;

import ladderGame.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String PLAYER_PRINT_INTERVAL = "\t";
    private static final String EMPTY_RUNG = "    |";
    private static final String RUNG = "----|";


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
        List<Layer> layers = ladder.getLayers();
        for (Layer layer : layers) {
            System.out.println(EMPTY_RUNG + printLayer(layer));
        }
    }

    private static String printLayer(Layer layer) {
        return layer.getRungs().stream()
                .map(rung -> drawGameRung(rung))
                .collect(Collectors.joining());
    }

    private static String drawGameRung(Rung rung) {
        return rung.isEmpty() ? EMPTY_RUNG : RUNG;
    }
}

