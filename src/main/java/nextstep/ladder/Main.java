package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.UserInput;
import nextstep.ladder.input.Input;
import nextstep.ladder.input.LadderHeight;
import nextstep.ladder.input.UserNames;
import nextstep.ladder.result.Result;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        UserNames userNames = Input.inputNames();
        LadderHeight ladderHeight = Input.inputLadderHeight();

        UserInput userInput = new UserInput(userNames, ladderHeight);

        Ladder ladder = new Ladder(userInput, idx -> new Random().nextBoolean());
        Result.printResult(ladder);
    }
}
