package ladder.Controller;

import ladder.model.LadderGame;
import ladder.view.Input;
import ladder.view.Result;

public class Ladder {
    public void game() {

        String[] users = Input.getUsers();
        int ladderHeight = Input.getLadderHeight();
        LadderGame ladderGame = new LadderGame(users);
        ladderGame.game(ladderHeight);

        Result.printUsers(ladderGame.getParticipant());
        Result.printLadder(ladderGame.getLines());
    }

}
