package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.RandomStepStrategy;
import nextstep.ladder.view.Drawer;
import nextstep.ladder.view.Input;

import java.util.List;

public class LadderGameApplication {

    public static void main(String[] args) {
        Input input = new Input();
        List<String> users = input.getUsersInput();
        int floor = input.getFloorInput();

        Ladder ladder = Ladder.of(floor, users, new RandomStepStrategy());

        System.out.println("실행 결과\n");
        Drawer drawer = new Drawer();
        drawer.printUserNames(ladder.getParticipants());
        drawer.printLadderInfo(ladder.getLadderInfo());
    }
}
