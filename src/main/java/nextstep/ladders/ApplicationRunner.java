package nextstep.ladders;

import nextstep.ladders.controller.LadderController;
import nextstep.ladders.domain.Ladder;
import nextstep.ladders.views.ConsoleInputView;
import nextstep.ladders.views.ConsoleOutputView;

import java.util.Scanner;

public class ApplicationRunner {

    public static final String ALL = "all";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ConsoleInputView inputView = new ConsoleInputView(scanner);
        ConsoleOutputView outputView = new ConsoleOutputView();
        LadderController ladderController = new LadderController();

        String participantsText = inputView.enterParticipants();
        String executionResultText = inputView.enterExecutionResult();
        String maxLadderHeightText = inputView.enterMaxLadderHeight();

        Ladder ladder = ladderController.start(participantsText, executionResultText, maxLadderHeightText);

        outputView.print(ladder);

        String name = inputView.enterToSeeTheResult();
        outputView.print(ladder, name);

        while (!ALL.equalsIgnoreCase(name)) {
            name = inputView.enterToSeeTheResult();
            outputView.print(ladder, name);
        }

        scanner.close();
    }
}
