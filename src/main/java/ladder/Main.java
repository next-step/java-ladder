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
        List<User> users = parseUserList(inputView.inputUserName()).stream()
            .map(User::new)
            .collect(toList());

        Ladder ladder = new Ladder(inputView.inputLadderHeight(), users.size());
        printLadderResult(ladder, users);
    }
}
