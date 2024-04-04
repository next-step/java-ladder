package nextstep.ladder;

import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

public class Main {

    public static void main(String[] args) {
        Users users = new Users(Input.inputPersonName());
        int height = Input.inputLadderHeight();

        Output.printResult(users, new Lines(height, users.size()));
    }
}
