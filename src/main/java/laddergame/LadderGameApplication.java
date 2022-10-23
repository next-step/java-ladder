package laddergame;

import laddergame.component.LadderFactory;
import laddergame.component.RandomLadderLineFactory;
import laddergame.controller.LadderGameRunner;
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
        LadderGameRunner game = new LadderGameRunner(ladderFactory);
        LadderGameResult result = game.run(request);
        OutputView.printLadderGame(request, result.getLadder());

        searchRewardByName(InputView.inputNameForSearch(), result.getRewardByName());
    }

    private static void searchRewardByName(String input, Map<String, String> rewardByName) {
        if (isPrintAllKeyword(input)) {
            OutputView.printAllNameAndReward(rewardByName);
            return;
        }
        try {
            OutputView.printReward(findRewardByName(input, rewardByName));
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        }
        searchRewardByName(InputView.inputNameForSearch(), rewardByName);
    }


    private static boolean isPrintAllKeyword(String input) {
        return input.equals(PRINT_ALL_KEYWORD);
    }

    private static String findRewardByName(String name, Map<String, String> rewardByName) {
        String foundReward = rewardByName.get(name);
        if (foundReward == null) {
            throw new IllegalArgumentException(String.format("'%s'는 참가하지 않은 참가자 이름입니다.", name));
        }
        return foundReward;
    }

}
