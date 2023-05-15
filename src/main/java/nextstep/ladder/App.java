package nextstep.ladder;

import nextstep.ladder.view.InputView;

public class App {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        String players = ladderGame.inputPlayers();
        ladderGame.addPlayers(players);
        int height = ladderGame.inputLadderHeight();
        ladderGame.saveLadder(height);
        ladderGame.addLine();
        ladderGame.printResultText();
        ladderGame.printPlayerName();
        ladderGame.printLadderLine();
    }

}
