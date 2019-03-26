package ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.players.Players;
import ladder.domain.rewards.Rewards;
import ladder.view.ConsoleInput;
import ladder.view.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        String playerNames = ConsoleInput.readPlayers();
        String rewardNames = ConsoleInput.readRewards();
        int ladderHeight = ConsoleInput.readLadderHeight();

        Players players = Players.generate(playerNames);

        Ladder ladder = new Ladder();
        ladder.generate(ladderHeight, players.size());

        Rewards rewards = Rewards.generate(rewardNames, players);

        ConsoleOutput.printPlayers(players);
        ConsoleOutput.printLadders(ladder);
        ConsoleOutput.printRewards(rewards);
    }
}
