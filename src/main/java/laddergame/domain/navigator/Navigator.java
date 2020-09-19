package laddergame.domain.navigator;

import laddergame.domain.line.Line;
import laddergame.domain.player.Player;

import java.util.Optional;

public class Navigator {

    public static void movePlayer(Line line, Player player) {

        makeLadderEdgeSpace(line);

        if (Optional.of(true).equals(Optional.ofNullable(line.getLine().get(player.getPosition())))) {
            player.moveLeft();
            removeLadderEdgeSpace(line);
            return;
        }

        if (Optional.of(true).equals(Optional.ofNullable(line.getLine().get(player.getPosition() + 1)))) {
            player.moveRight();
        }

        removeLadderEdgeSpace(line);
    }

    private static void makeLadderEdgeSpace(Line line) {
        line.getLine().add(0, null);
        line.getLine().add(null);
    }

    private static void removeLadderEdgeSpace(Line line) {
        line.getLine().remove(line.getLine().size() - 1);
        line.getLine().remove(0);
    }
}