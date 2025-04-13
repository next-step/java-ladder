package ladder;

import java.util.List;
import java.util.Scanner;

import ladder.domain.Ladder;
import ladder.domain.User;
import ladder.view.InputView;

import static java.util.stream.Collectors.toList;
import static ladder.util.StringUtil.parseUserList;
import static ladder.view.OutputView.printLadderResult;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String userInput = inputView.inputUserName();

        List<User> users = parseUserList(userInput).stream()
            .map(User::new)
            .collect(toList());

        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, users.size());
        printLadderResult(ladder, users);
    }
}
