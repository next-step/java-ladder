package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.ConsoleInput;
import ladder.view.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        String playerNames = ConsoleInput.readPlayers();
        int ladderHeight = ConsoleInput.readLadderHeight();

        Players players = Players.generate(playerNames);

        Ladder ladder = new Ladder();
        ladder.generate(ladderHeight, players.size());

        ConsoleOutput.printPlayers(players);
        ConsoleOutput.printLadders(ladder);
    }
}
