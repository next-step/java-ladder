package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.UserInput;
import nextstep.ladder.input.Input;
import nextstep.ladder.result.Result;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final UserInput userInput = Input.input();

        Ladder ladder = new Ladder(userInput, idx -> new Random().nextBoolean());
        Result.printResult(ladder);
    }
}
