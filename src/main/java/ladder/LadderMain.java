package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.*;
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

        outputView.printParticipateInUsers(userNames);

        outputView.printLadder(ladder.lines());

        outputView.printResult(inputResult);

        LadderGame ladderGame = new LadderGame(users, ladder.lines());
        users = ladderGame.start();

        String inputShowUserName = inputView.inputShowUserResult();

        GameResult gameResult = new GameResult(inputResult);


        if(inputShowUserName.equals("all") || inputShowUserName.equals("ALL")){
            Map<String,String> gameResults = gameResult.allResults(users);
            outputView.printUserResults(gameResults);
        }

        if(!(inputShowUserName.equals("all") || inputShowUserName.equals("ALL"))){
            User user = users.findByName(inputShowUserName);
            outputView.printUserResult(gameResult.showResult(user.position()));
        }

    }
}
