package ladder;

import ladder.controller.Game;
import newladder.interfaces.Ladder;
import newladder.model.MyLadderGame;

public class LadderMainController {
    public static void main(String[] args) {
        MyLadderGame ladderGame = new MyLadderGame(3, 5);
    }
}
