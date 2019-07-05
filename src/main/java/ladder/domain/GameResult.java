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

    public void run(LadderGame ladderGame) {
        IntStream.range(0, ladderGame.getUseGroup().size()).
                forEach(i -> runLadderGame(ladderGame, makeLadderMapArr(ladderGame), ladderGame.getUseGroup().get(i).getName()));

        getResult(ladderGame.getUseGroup());
    }

    private void runLadderGame(LadderGame ladderGame, Boolean[][] ladderMap, String request) {
        int moveFlag = 0;

        for (int i = 0; i < ladderGame.getLadder().size(); ++i) {
            for (int j = 1; j < ladderGame.getUseGroup().size(); ++j) {
                // 좌측으로 움직이는 조건
                if (ladderGame.getUser(request).getPosition().getCol() == j && ladderMap[i][j].equals(Boolean.TRUE)) {
                    ladderGame.getUser(request).getPosition().moveLeft();
                    moveFlag += 1;
                    break;
                }
                // 좌측으로 움직이는 조건
                if (ladderGame.getUser(request).getPosition().getCol() + 1 == j && ladderMap[i][j].equals(Boolean.TRUE)) {
                    ladderGame.getUser(request).getPosition().moveRight();
                    moveFlag += 1;
                    break;
                }
            }
            // 좌 우측 움직이 없을때 직진
            if (moveFlag == i) {
                ladderGame.getUser(request).getPosition().moveStraight();
                moveFlag += 1;
            }
        }
    }

    public void getResult(List<GameUser> userGroup) {
        IntStream.range(0, gameReward.size()).
                forEach(i -> {
                    gameReward.get(i).matchReward(userGroup);
                });
    }

    // listArray를 array로 변환 (게임 결과 확인을 위해서)
    private Boolean[][] makeLadderMapArr(LadderGame ladderGame) {
        Line[] ladderArr = ladderGame.getLadder().toArray(new Line[ladderGame.getLadder().size()]);
        Boolean[][] map = new Boolean[ladderGame.getLadder().size()][ladderGame.getLadder().size()];

        for (int i = 0; i < ladderArr.length; ++i) {
            map[i] = ladderArr[i].getPoints().toArray(new Boolean[ladderGame.getLadder().size()]);
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





