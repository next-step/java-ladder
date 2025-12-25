package nextstep.ladder;


import nextstep.ladder.domain.ladder.Ladders;
import nextstep.ladder.domain.user.Users;

import static nextstep.ladder.view.InputView.*;

public class main {

    public static void main(String[] args) {
        printPeopleName();
        Users users = new Users(inputName());

        printLadderHeight();
        Ladders ladders = new Ladders(inputHeight(), users.size());

        printResultMessage();

        printLadders(users, ladders);
    }
}
