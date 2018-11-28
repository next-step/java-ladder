package net.chandol;

import net.chandol.domain.LadderGame;
import net.chandol.domain.bridge.RandomBridgeSupplier;
import net.chandol.request.LadderGameInitializeRequest;
import net.chandol.view.LadderGameConsoleView;

import static net.chandol.view.LadderGameConsoleView.getLadderGameInitializeRequest;

public class ConsoleMain {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new RandomBridgeSupplier());

        LadderGameInitializeRequest request = getLadderGameInitializeRequest();
        ladderGame.initializeLadder(request);

        LadderGameConsoleView.drawLadderAndPlayers(ladderGame);
    }
}
