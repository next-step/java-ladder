package nextstep.ladder.view;

import java.util.Scanner;

import static nextstep.ladder.constant.PrintMessage.*;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputParticipateUsers() {
        System.out.println(QUESTION_TEXT_JOIN_USERS);
        return scanner.nextLine();
    }

    public String inputResultReward() {
        System.out.println(QUESTION_TEXT_RESULT_REWARD);
        return scanner.nextLine();
    }

    public int inputLadderHeight() {
        System.out.println(QUESTION_TEXT_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputShowResultTarget() {
        System.out.println(QUESTION_TEXT_RESULT_TARGET);
        return scanner.nextLine();
    }
}
