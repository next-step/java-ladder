package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderApplication {

    public static void main(String[] args) {

        List<String> names = InputView.inputUserNames();
        Users users = new Users(names);

        List<String> results = InputView.inputLadderResult();
        LadderResults ladderResults = new LadderResults(results);

        int height = InputView.inputLadderHeight();

        Ladder ladder = Ladder.createLadder(users.getUsers().size(), height, () -> new Random().nextBoolean());
        OutputView.display(users, ladder, ladderResults);

        List<User> usersAfter = users.getUsers().stream()
                .map(user -> user.rideLadder(ladder))
                .collect(Collectors.toList());

        String name = InputView.inputUserName();

        if (name.equals("all")) {
            OutputView.announceAllUsers(usersAfter, ladderResults);
            return;
        }
        OutputView.announceUser(name, usersAfter, ladderResults);
    }
}
