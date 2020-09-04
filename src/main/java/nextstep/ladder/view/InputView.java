package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGameManager;

import java.util.Scanner;

import static nextstep.ladder.constant.PrintMessage.QUESTION_TEXT_JOIN_USERS;
import static nextstep.ladder.constant.PrintMessage.QUESTION_TEXT_LADDER_HEIGHT;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public LadderGameManager inputLadderGameManager() {
        return LadderGameManager.create(inputParticipateUsers(), inputLadderHeight());
    }

    private String inputParticipateUsers() {
        System.out.println(QUESTION_TEXT_JOIN_USERS);
        return scanner.nextLine();
    }

    private int inputLadderHeight() {
        System.out.println(QUESTION_TEXT_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }
}
