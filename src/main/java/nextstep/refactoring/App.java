package nextstep.refactoring;

import nextstep.ladder.Users;
import nextstep.refactoring.strategy.RandomGenerator;
import nextstep.refactoring.view.InputView;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Users users = InputView.getUserNames();
        List<String> executeResult = InputView.getExecuteResult();
        int height = InputView.getHeight();

        Ladder ladder = new Ladder(height, users.getSize(), new RandomGenerator());

    }
}
