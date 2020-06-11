package nextstep.ladder.domain;

import nextstep.ladder.ui.InputView;

import java.util.List;

public class LadderGame {
    public static void main(String[] argv) {
        InputView inputView = new InputView();

        List<User> userList = inputView.insertUserLine();
    }
}
