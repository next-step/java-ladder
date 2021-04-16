package step2.controller;

import step2.domain.Line;
import step2.domain.Lines;
import step2.domain.Player;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Player> players = LadderController.getPlayers();
        int height = LadderController.getHeight();
        Lines lines = LadderController.createLines(players.size(), height);

        LadderController.showResult(players, lines);
    }
}
