package laddergame;

import laddergame.component.LadderFactory;
import laddergame.component.RandomLadderLineFactory;
import laddergame.controller.LadderGame;
import laddergame.dto.LadderGameResult;
import laddergame.dto.LadderGameRunRequest;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.Map;

public class LadderGameApplication {

    private static final String PRINT_ALL_KEYWORD = "all";

    public static void main(String[] args) {
        LadderGameRunRequest request = InputView.inputLadderGameRunRequest();
        LadderFactory ladderFactory = new LadderFactory(new RandomLadderLineFactory());
        LadderGame game = new LadderGame(ladderFactory);
        LadderGameResult result = game.run(request);
        OutputView.printLadderGameState(request, result.getLadder());

        searchRewardByName(result.getRewardByName());
    }

    private static void searchRewardByName(Map<String, String> rewardByName) {
        String nameForSearch = InputView.inputNameForSearch();
        while (!isPrintAllKeyword(nameForSearch)) {
            try {
                OutputView.printReward(findRewardByName(rewardByName, nameForSearch));
            } catch (Exception e) {
                OutputView.printError(e.getMessage());
            }
            nameForSearch = InputView.inputNameForSearch();
        }
        OutputView.printAllNameAndReward(rewardByName);
    }

    private static boolean isPrintAllKeyword(String input) {
        return input.equals(PRINT_ALL_KEYWORD);
    }

    private static String findRewardByName(Map<String, String> rewardByName, String name) {
        String foundReward = rewardByName.get(name);
        if (foundReward == null) {
            throw new IllegalArgumentException(String.format("'%s'는 참가하지 않은 참가자 이름입니다.", name));
        }
        return foundReward;
    }

}
