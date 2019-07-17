package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameResult {
    private List<GameReward> gameReward;

    public GameResult(String userReward, int sizeOfUserGroup) {
        String[] namesOfReward = checkReward(LadderUtil.splitName(userReward), sizeOfUserGroup);
        gameReward = new ArrayList<>();

        for (int i = 0; i < namesOfReward.length; ++i) {
            GameReward gameRewardElement = new GameReward(namesOfReward[i], i);
            gameReward.add(gameRewardElement);
        }
    }

    public void run(List<LadderLine> ladder, List<SingleUser> userGroup) {
        for (SingleUser user : userGroup) {
            user.playLadderGame(ladder);
        }

        getResult(userGroup);
    }

    public List<GameReward> getgameReward() {
        return gameReward;
    }

    void getResult(List<SingleUser> userGroup) {
        for (int i = 0; i < userGroup.size(); ++i) {
            gameReward.get(i).matchReward(userGroup);
        }
    }

    private String[] checkReward(String[] inputStrings, Integer sizeOfUserGroup) {
        Integer sizeOfInput = inputStrings.length;
        Arrays.stream(inputStrings)
                .filter(inputString -> "".equals(inputString) || inputString.equals(" ")
                        || inputString.equals("\n") || !sizeOfInput.equals(sizeOfUserGroup))
                .forEach(inputString -> {
                    throw new IllegalArgumentException("실행 결과의 입력값이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
                });

        return inputStrings;
    }
}





