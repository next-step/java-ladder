package nextstep.ladder;


import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.LadderGame;
import nextstep.ladder.domain.strategy.RandomLadderLineGenerateStrategy;
import nextstep.ladder.domain.user.Users;

import static nextstep.ladder.view.InputView.*;

public class main {

    public static void main(String[] args) {
        printPeopleName();
        Users users = inputName();

        printLadderHeight();
        Height height = inputHeight();

        LadderGame ladderGame = new LadderGame(users, height, new RandomLadderLineGenerateStrategy());

        printResultMessage();

        printLadders(ladderGame);
    }
}
