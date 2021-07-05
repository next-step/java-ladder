package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] userNames = inputView.inputParticipateInUsers();

        List<User> userList = new ArrayList<>();
        Arrays.stream(userNames).forEach(username -> userList.add(new User(username)));

        Users users = new Users(userList);
        users.checkDuplicateUser();

        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, userList.size());

        OutputView outputView = new OutputView();
        outputView.printPaticipateInUsers(userNames);

        outputView.printLadder(ladder.lines());
    }
}
