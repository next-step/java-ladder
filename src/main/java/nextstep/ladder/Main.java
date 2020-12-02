package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Results;

public class Main {
    public static void main(String[] args) {
        Players players = LadderController.getPlayers();
        int height = LadderController.getHeight();
        Lines lines = LadderController.createLines(players, height);
        Results results = LadderController.getResults(players.getSize());

        LadderController.showPlayers(players);
        LadderController.showLines(lines);
        LadderController.showResults(results);
        

    }
}
