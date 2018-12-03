package net.chandol.ladder.v1;

import net.chandol.ladder.v1.domain.LadderGame;
import net.chandol.ladder.v1.domain.bridge.RandomBridgeSupplier;
import net.chandol.ladder.v1.request.LadderGameInitializeRequest;
import net.chandol.ladder.v1.view.LadderGameConsoleView;

import static net.chandol.ladder.v1.view.LadderGameConsoleView.getLadderGameInitializeRequest;

public class ConsoleMain {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new RandomBridgeSupplier());

        LadderGameInitializeRequest request = getLadderGameInitializeRequest();
        ladderGame.initializeLadder(request);

        LadderGameConsoleView.drawLadderAndPlayers(ladderGame);
    }
}
