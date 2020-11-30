package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Players;

public class Main {
    public static void main(String[] args) {
        Players players = LadderController.getPlayers();
        int height = LadderController.getHeight();
        Lines lines = LadderController.createLines(players, height);

        LadderController.showResult(players, lines);
    }
}
