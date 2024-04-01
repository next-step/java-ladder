package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.RandomLineStrategy;
import nextstep.ladder.view.DrawerView;
import nextstep.ladder.view.InputView;

import java.util.List;

public class LadderGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> users = inputView.getUsersInput();
        List<String> ladderGameWinningProduct = inputView.getLadderGameResults();
        int floor = inputView.getFloorInput();

        LadderGame ladderGame = new LadderGame(users, floor, ladderGameWinningProduct, new RandomLineStrategy());

        DrawerView drawerView = new DrawerView();
        drawerView.printLadderGameResult(ladderGame.getParticipants(), ladderGame.getLadderInfo(), ladderGameWinningProduct);

        while (true) {
            String resultTarget = inputView.getGameResultTargetUser();
            drawerView.printWinningProductOfUser(resultTarget, ladderGame);
        }
    }
}
