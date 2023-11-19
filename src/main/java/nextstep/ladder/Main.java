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
        LadderHeight ladderHeight = Input.inputLadderHeight();

        UserInput userInput = new UserInput(userNames, ladderHeight);

        Ladder ladder = new Ladder(userInput, idx -> new Random().nextBoolean());
        printResult(ladder);
    }

    private static void printResult(final Ladder ladder) {
        printMakingLadderResult(ladder);
    }

    private static void printMakingLadderResult(final Ladder ladder) {
        System.out.println("\n실행결과\n");
        System.out.println(ladder);
    }
}
