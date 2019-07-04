package nextstep.domain;

import java.util.stream.IntStream;

public class GameResult {

    public static void run(LadderGame ladderGame, Boolean[][] ladderMap) {
        IntStream.range(0, ladderGame.getUseGroup().size()).
                forEach(i -> runLadderGame(ladderGame, ladderMap, ladderGame.getUseGroup().get(i).getName()));
    }

    private static void runLadderGame(LadderGame ladderGame, Boolean[][] ladderMap, String request) {
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
}





