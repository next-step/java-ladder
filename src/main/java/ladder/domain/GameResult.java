package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class GameResult {
    private static final String SEPARATOR = ",";

    private List<GameReward> gameReward;

    public GameResult(String userReward, int maxHeight) {
        String[] namesOfReward = checkReward(splitName(userReward));
        gameReward = new ArrayList<>();

        IntStream.range(0, namesOfReward.length)
                .forEach(i -> {
                    GameReward gameRewardElement = new GameReward(namesOfReward[i], maxHeight, i);
                    gameReward.add(gameRewardElement);

                });
    }

    public void run(LadderFactory ladderFactory, UserGroup userGroup) {
        IntStream.range(0, userGroup.getUserGroup().size()).
                forEach(i -> userGroup.runLadderGame(ladderFactory, makeLadderMapArr(ladderFactory), userGroup.getUserGroup().get(i).getName()));

        getResult(userGroup.getUserGroup());
    }

    public void getResult(List<SingleUser> userGroup) {
        IntStream.range(0, gameReward.size()).
                forEach(i -> {
                    gameReward.get(i).matchReward(userGroup);
                });
    }

    public List<GameReward> getgameReward() {
        return gameReward;
    }

    // listArray를 array로 변환 (게임 결과 확인을 위해서)
    private Boolean[][] makeLadderMapArr(LadderFactory ladderFactory) {
        Line[] ladderArr = ladderFactory.getLadder().toArray(new Line[ladderFactory.getLadder().size()]);
        Boolean[][] map = new Boolean[ladderFactory.getLadder().size()][ladderFactory.getLadder().size()];

        for (int i = 0; i < ladderArr.length; ++i) {
            map[i] = ladderArr[i].getPoints().toArray(new Boolean[ladderFactory.getLadder().size()]);
        }

        return map;
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





