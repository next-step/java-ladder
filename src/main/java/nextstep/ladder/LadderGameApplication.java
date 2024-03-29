package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.RandomStepStrategy;
import nextstep.ladder.view.DrawerView;
import nextstep.ladder.view.InputView;

import java.util.List;

public class LadderGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> users = inputView.getUsersInput();
        int floor = inputView.getFloorInput();

        Ladder ladder = Ladder.of(floor, users, new RandomStepStrategy());

        System.out.println("실행 결과\n");
        DrawerView drawerView = new DrawerView();
        drawerView.printUserNames(ladder.getParticipants());
        drawerView.printLadderInfo(ladder.getLadderInfo());
    }
}
