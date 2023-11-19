package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.UserInput;
import nextstep.ladder.input.Input;
import nextstep.ladder.input.LadderHeight;
import nextstep.ladder.input.UserNames;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        UserNames userNames = Input.inputNames();
        System.out.println("userNames = " + userNames);

        LadderHeight ladderHeight = Input.inputLadderHeight();
        System.out.println("ladderHeight = " + ladderHeight);

        UserInput userInput = new UserInput(userNames, ladderHeight);

        Ladder ladder = new Ladder(userInput, idx -> new Random().nextBoolean());
    }
}
