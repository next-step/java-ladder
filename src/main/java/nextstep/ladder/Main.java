package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.*;

public class Main {
    public static void main(String[] args) {
        Players players = LadderController.getPlayers();
        Results results = LadderController.getResults(players.getSize());
        int height = LadderController.getHeight();
        Lines lines = LadderController.createLines(players, height);

        LadderController.showPlayers(players);
        LadderController.showLines(lines);
        LadderController.showResults(results);

        PlayersOnLine lastPlayersOnLine = LadderController.climb(players, lines);
        Matches matches = LadderController.match(lastPlayersOnLine, results);

        String nameToFind = LadderController.getNameToFind();
        LadderController.showMatchResult(matches, nameToFind);
    }
}
