package step2;

import step2.controller.LadderController;
import step2.domain.Line;
import step2.domain.Lines;
import step2.domain.Player;
import step2.domain.Players;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Players players = LadderController.getPlayers();
        int height = LadderController.getHeight();
        Lines lines = LadderController.createLines(players.getSize(), height);

        LadderController.showResult(players, lines);
    }
}
