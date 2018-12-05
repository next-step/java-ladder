package net.chandol.ladder.v2;

import net.chandol.ladder.v2.domain.LadderGame;
import net.chandol.ladder.v2.domain.line.RandomLinesGenerator;
import net.chandol.ladder.v2.dto.LadderInitializeRequest;
import net.chandol.ladder.v2.view.LadderGameConsoleView;

import static net.chandol.ladder.v2.view.LadderGameConsoleView.getGameResultUntilAll;
import static net.chandol.ladder.v2.view.LadderGameConsoleView.getLadderGameInitializeRequest;

public class ConsoleMain {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new RandomLinesGenerator());

        LadderInitializeRequest request = getLadderGameInitializeRequest();
        ladderGame.initializeLadder(request);

        LadderGameConsoleView.drawLadderAndPlayers(ladderGame);

        getGameResultUntilAll(ladderGame.getResult());
    }
}
