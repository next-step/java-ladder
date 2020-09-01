package nextstep.ladder;

import nextstep.ladder.domain.UserGenerator;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.Scanner;

public class LadderGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String joinUsers = InputView.inputGameUser(scanner);

        Users users = new Users(UserGenerator.generateUsers(joinUsers));

        int ladderHeight = InputView.inputLadderHeight(scanner);

        OutputView.printGameResult();
    }
}
