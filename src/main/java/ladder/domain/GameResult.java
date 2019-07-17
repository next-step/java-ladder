package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameResult {
    private static final String SEPARATOR = ",";

    private List<GameReward> gameReward;

    public GameResult(String userReward) {
        String[] namesOfReward = checkReward(splitName(userReward));
        gameReward = new ArrayList<>();

        for (int i = 0; i < namesOfReward.length; ++i) {
            GameReward gameRewardElement = new GameReward(namesOfReward[i], i);
            gameReward.add(gameRewardElement);
        }
    }

    public void run(List<LadderLine> ladder, UserGroup userGroup) {
        ladder.stream()
                .forEach(line -> {
                    userGroup.getUserGroup().stream()
                            .forEach(user -> user.playLadderGame(ladder));
                });

        getResult(userGroup.getUserGroup());
    }

    public List<GameReward> getgameReward() {
        return gameReward;
    }

    private void getResult(List<SingleUser> userGroup) {
        for (int i = 0; i < userGroup.size(); ++i) {
            gameReward.get(i).matchReward(userGroup);
        }
    }

    private String[] splitName(String names) {
        return names.split(SEPARATOR);
    }

    private String[] checkReward(String[] inputStrings) {
        Arrays.stream(inputStrings)
                .filter(inputString -> "".equals(inputString) || inputString.equals(" ")
                        || inputString.equals("\n"))
                .forEach(inputString -> {
                    throw new IllegalArgumentException("입력값이 잘못되었습니다. 실행 결과를 다시 한번 입력해주세요.");
                });

        return inputStrings;
    }
}





