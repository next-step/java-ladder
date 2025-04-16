package ladder;

import java.util.List;
import java.util.Scanner;

import ladder.domain.Ladder;
import ladder.domain.LadderSimulator;
import ladder.domain.LineFactory;
import ladder.domain.User;
import ladder.view.InputView;

import static java.util.stream.Collectors.toList;
import static ladder.util.StringUtil.parse;
import static ladder.view.OutputView.outputLadderResult;
import static ladder.view.OutputView.printLadderResult;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String userInput = inputView.inputUserName();

        List<User> users = parse(userInput).stream()
            .map(User::new)
            .collect(toList());

        List<String> results = parse(inputView.inputPlayResult());

        int height = inputView.inputLadderHeight();
        LineFactory factory = new LineFactory(height, users.size());
        Ladder ladder = factory.createLadder();
        printLadderResult(ladder, users, results);

        LadderSimulator simulator = new LadderSimulator(ladder, users, results);
        outputLadderResult(simulator, inputView);
    }
}
