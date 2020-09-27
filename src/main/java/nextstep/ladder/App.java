package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;
import nextstep.ladder.view.UsersRaw;

public class App {
    public static void main(String[] args) {
        String personsRaw = InputView.inputUser();
        Users users = UsersRaw.createUsers(personsRaw);

        int height = InputView.inputHeight();

        Ladder ladder = Ladder.of(users.countOfUsers(), height);

        OutputView.drawLadder(ladder, users.maxUserNameLength());

    }
}
