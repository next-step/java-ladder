package nextstep.ladder;

import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;

public class LadderMain {
    public static void main(String[] args) {
        Users users = InputView.inputUserNames();

        System.out.println("users = " + users);
    }
}
