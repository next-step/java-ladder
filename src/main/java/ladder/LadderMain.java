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

        Arrays.stream(userNames).forEach(username -> userList.add(new User(username, userOfInitIndex.getAndIncrement() * 2)));

        Users users = new Users(userList);
        users.checkDuplicateUser();

        String[] inputResult = inputView.inputResult();


        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, userList.size());


        OutputView outputView = new OutputView();
        for (User user : users.userList()) {
            System.out.printf("%6s", user.position());
        }
        System.out.println();

        outputView.printParticipateInUsers(userNames);

        outputView.printLadder(ladder.lines());

        outputView.printResult(inputResult);

        LadderGame ladderGame = new LadderGame(users, ladder.lines());
        users = ladderGame.start();

        String inputShowUserName = inputView.inputShowUserResult();
        users.findByName(inputShowUserName);
//        GameResult gameResult = new GameResult(inputResult);
//
//        if(inputShowUser.equals("all") || inputShowUser.equals("ALL")){
//
//            outputView.printGameResult(users.userList());
//        }




    }
}
