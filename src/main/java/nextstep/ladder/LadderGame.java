package nextstep.ladder;

import nextstep.ladder.domain.UserGenerator;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;

import java.util.Scanner;

public class LadderGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String joinUsers = InputView.setGameUser(scanner);

        Users users = new Users(UserGenerator.generateUsers(joinUsers));

    }
}
