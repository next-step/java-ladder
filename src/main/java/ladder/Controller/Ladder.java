package ladder.Controller;

import ladder.model.LadderGame;
import ladder.model.Prize;
import ladder.model.RandomLineStrategy;
import ladder.view.Input;
import ladder.view.Result;

import java.util.List;

public class Ladder {
    private static final RandomLineStrategy randomLineStrategy = new RandomLineStrategy();

    public void makeLadder() {
        String[] users = Input.getUsers();
        String[] prizeList = Input.getPrizeList();
        Prize prize = new Prize(prizeList);
        int ladderHeight = Input.getLadderHeight();

        LadderGame ladderGame = new LadderGame(users);
        ladderGame.makeGame(ladderHeight, randomLineStrategy);
        makeResult(ladderGame, prize);
    }

    public void makeResult(LadderGame ladderGame, Prize prize) {
        Result.printUsers(ladderGame.getParticipant());
        Result.printLadder(ladderGame.ladderInfo().getLines());
        Result.printPrize(prize);

        ladderGame.gameResult(prize);
        while(true) {
            Result.printResult(ladderGame.getParticipant());
        }
    }
}
