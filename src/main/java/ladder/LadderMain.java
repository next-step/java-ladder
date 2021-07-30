package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] userNames = inputView.inputParticipateInUsers();

        List<User> userList = new ArrayList<>();

        AtomicInteger userOfInitIndex = new AtomicInteger();

        Arrays.stream(userNames).forEach(username -> userList.add(new User(username, userOfInitIndex.getAndIncrement())));

        Users users = new Users(userList);
        users.checkDuplicateUser();

        String[] inputResult = inputView.inputResult();


        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, userList.size());

        OutputView outputView = new OutputView();
        outputView.printIndexParticipateInUsers(userNames);
        outputView.printParticipateInUsers(userNames);

        outputView.printLadder(ladder.lines());

        outputView.printResult(inputResult);
    }
}
