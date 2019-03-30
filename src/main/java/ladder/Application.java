package ladder;

import ladder.domain.enums.Complexity;
import ladder.domain.ladder.Ladder;
import ladder.domain.players.Players;
import ladder.domain.result.LadderGame;
import ladder.domain.result.LadderResult;
import ladder.domain.rewards.Rewards;
import ladder.view.ConsoleInput;
import ladder.view.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        String playerNames = ConsoleInput.readPlayers();
        String rewardNames = ConsoleInput.readRewards();
        String ladderDifficulty = ConsoleInput.readLadderDifficulty();

        Players players = Players.generate(playerNames);

        Ladder ladder = new Ladder();
        ladder.generate(Complexity.of(ladderDifficulty), players.size());

        Rewards rewards = Rewards.generate(rewardNames, players);

        ConsoleOutput.printPlayers(players);
        ConsoleOutput.printLadders(ladder);
        ConsoleOutput.printRewards(rewards);

        LadderGame ladderGame = LadderGame.generate(players, rewards);
        LadderResult ladderResult = ladderGame.result(ladder);

        boolean exit = false;
        while (!exit) {
            String nameForRewards = ConsoleInput.readNameForRewards();
            ConsoleOutput.printRewardOfPlayers(ladderResult, nameForRewards);
            if (nameForRewards.equals("exit")) {
                exit = true;
            }
        }
    }
}
