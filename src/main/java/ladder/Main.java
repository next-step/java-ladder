package ladder;

import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String playerNamesString = InputView.getJoinMembersString();
        int maxLadderHeight = InputView.getMaxLadderHeight();
        String resultsString = InputView.getResultsString();

        LadderPlayerNames playerNames = LadderPlayerNames.of(playerNamesString);

        Ladder ladder = Ladder.of(playerNames.countOfPerson(), resultsString, maxLadderHeight);

        ResultView.printLunchResult(playerNames, ladder);

        givenPlayerNameThen(playerName -> {
            List<LadderResult> ladderResults = computeLadderResults(playerNames, playerName, ladder);
            ResultView.printRewardResult(ladderResults);
        });
    }

    private static List<LadderResult> computeLadderResults(LadderPlayerNames playerNames, String playerName, Ladder ladder) {
        List<Integer> playerNameIndexes = playerNames.getIndexesOf(playerName);
        return playerNameIndexes.stream()
                                .map(position -> createLadderResult(position, playerNames, ladder))
                                .collect(Collectors.toList());
    }

    private static LadderResult createLadderResult(int beginPosition, LadderPlayerNames ladderPlayerNames, Ladder ladder) {
        String sPlayerName = ladderPlayerNames.getPlayerName(beginPosition);
        LadderReward reward = ladder.computePlayerReward(beginPosition);
        return new LadderResult(sPlayerName, reward);
    }

    private static void givenPlayerNameThen(Consumer<String> playerNameConsumer) {
        while (true) {
            String playerName = InputView.getResultOfPersonName();
            playerNameConsumer.accept(playerName);
            if (playerName.equals("all")) {
                break;
            }
        }
    }
}
