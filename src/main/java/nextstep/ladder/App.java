package nextstep.ladder;

public class App {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        String players = ladderGame.inputPlayers();
        ladderGame.addPlayers(players);
        int height = ladderGame.inputLadderHeight();
        ladderGame.saveLadder(height);
        ladderGame.addLine();
        ladderGame.printPlayerName();
        ladderGame.printLadderLine();
    }

}
