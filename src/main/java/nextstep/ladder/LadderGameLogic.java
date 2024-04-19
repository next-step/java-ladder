package nextstep.ladder;

import nextstep.ladder.domain.LadderBoard;
import nextstep.ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderGameLogic {

    public static void logic(LadderBoard ladderBoard, List<GameUser> gameUsers) {
        for (GameUser gameUser : gameUsers) {
            System.out.println(gameUser.getUserName() + " " + gameUser.getPosition().getPosition());
            for (int j = 0; j < ladderBoard.getLadderBoard().size(); j++) {
                Line line = ladderBoard.getLine(j);
                gameUser.move(line);
                System.out.println("height = "+ j + "position = " +gameUser.getPosition().getPosition());
            }
        }
    }

}
