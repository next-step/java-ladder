import ladder.Ladder;
import ladder.LadderPlayerNames;
import ladder.LadderResult;
import ladder.LadderRewardType;
import ladder.LadderRewards;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String playerNamesString = InputView.getJoinMembersString();
        int maxLadderHeight = InputView.getMaxLadderHeight();

        LadderPlayerNames ladderPlayerNames = LadderPlayerNames.of(playerNamesString);
        int countOfPerson = ladderPlayerNames.size();
        int countOfColumn = countOfPerson - 1;

        Ladder ladder = Ladder.of(countOfColumn, maxLadderHeight);
        LadderRewards ladderRewards = LadderRewards.of(countOfPerson);

        ResultView.printLunchResult(ladderPlayerNames, ladder, ladderRewards);

        while (true) {
            String playerName = InputView.getResultOfPersonName();
            List<Integer> playerNameIndexes = ladderPlayerNames.getIndexesOf(playerName);
            List<LadderRewardType> ladderRewardTypes = ladderRewards.getLadderRewardTypes();

            List<LadderResult> ladderResults
                    = playerNameIndexes.stream()
                                       .map(position -> {
                                           String sPlayerName = ladderPlayerNames.getPlayerName(position);
                                           LadderRewardType rewardType = computeLadderRewardType(position, ladder, ladderRewardTypes);
                                           return new LadderResult(sPlayerName, rewardType);
                                       })
                                       .collect(Collectors.toList());

            ResultView.printRewardResult(ladderResults);
            if (playerName.equals("all")) {
                break;
            }
        }

    }

    private static LadderRewardType computeLadderRewardType(int position, Ladder ladder, List<LadderRewardType> types) {
        int rewardPosition = ladder.getRewardPosition(position);
        return types.get(rewardPosition);

    }
}
