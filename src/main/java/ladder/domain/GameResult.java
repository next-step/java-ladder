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
        GameReward gameRewardElement;

        for (int i = 0; i < namesOfReward.length; ++i) {
            gameRewardElement = new GameReward(namesOfReward[i], maxHeight, i);
            gameReward.add(gameRewardElement);
        }
    }

    public void run(LadderFactory ladderFactory, UserGroup userGroup) {
        IntStream.range(0, userGroup.getUserGroup().size()).
                forEach(i -> runLadderGame(ladderFactory, userGroup, makeLadderMapArr(ladderFactory), userGroup.getUserGroup().get(i).getName()));

        getResult(userGroup.getUserGroup());
    }

    private void runLadderGame(LadderFactory ladderFactory, UserGroup userGroup, Boolean[][] ladderMap, String requestName) {
        int moveFlag = 0;

        for (int i = 0; i < ladderFactory.getLadder().size(); ++i) {
            for (int j = 1; j < userGroup.getUserGroup().size(); ++j) {
                // 좌측으로 움직이는 조건
                if (userGroup.compareCol(requestName, j) && ladderMap[i][j].equals(Boolean.TRUE)) {
                    userGroup.moveLeft(requestName);
                    moveFlag += 1;
                    break;
                }
                // 좌측으로 움직이는 조건
                if (userGroup.compareNextCol(requestName, j) && ladderMap[i][j].equals(Boolean.TRUE)) {
                    userGroup.moveRight(requestName);
                    moveFlag += 1;
                    break;
                }
            }
            // 좌 우측 움직이 없을때 직진
            if (moveFlag == i) {
                userGroup.moveStraight(requestName);
                moveFlag += 1;
            }
        }
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
                .filter(inputString -> inputString.isEmpty() || inputString.equals(" ")
                        || inputString.equals("\n"))
                .forEach(inputString -> {
                    throw new IllegalArgumentException("입력값이 잘못되었습니다. 실행 결과를 다시 한번 입력해주세요.");
                });

        return inputStrings;
    }
}





