package ladder;

import ladder.view.InputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> users = InputView.createUsers();
        int ladderHeight = InputView.createLadderHeight();
    }
}
