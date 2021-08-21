package nextstep.ladders;

import nextstep.ladders.controller.LadderController;
import nextstep.ladders.domain.Ladder;
import nextstep.ladders.domain.LadderInfo;
import nextstep.ladders.domain.Participants;
import nextstep.ladders.views.ConsoleInputView;
import nextstep.ladders.views.ConsoleOutputView;

import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ConsoleInputView inputView = new ConsoleInputView(scanner);
        ConsoleOutputView outputView = new ConsoleOutputView();
        LadderController ladderController = new LadderController();

        String participantsText = inputView.enterParticipants();
        String executionResultText = inputView.enterExecutionResult();
        String maxLadderHeightText = inputView.enterMaxLadderHeight();

        LadderInfo ladderInfo = ladderController.register(participantsText, executionResultText);
        Participants participants = ladderInfo.getParticipants();

        Ladder ladder = ladderController.start(participants.count(), maxLadderHeightText);

        outputView.print(ladder, ladderInfo);

        while (true) {
            String name = inputView.enterToSeeTheResult();
            outputView.print(ladder, ladderInfo, name);

            if ("all".equalsIgnoreCase(name)) {
                break;
            }
        }

        scanner.close();
    }
}
