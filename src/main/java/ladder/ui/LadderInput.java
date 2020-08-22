package ladder.ui;

import java.util.Scanner;

import static ladder.ui.LadderDisplay.display;

public final class LadderInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static LadderBaseInputData inputLadderBaseData() {
        String participants = inputParticipants();
        String ladderResult = inputLadderResult();
        int ladderHeight = inputLadderHeight();
        return new LadderBaseInputData(participants, ladderResult, ladderHeight);
    }

    private static String inputParticipants() {
        display("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    private static String inputLadderResult() {
        display("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    private static int inputLadderHeight() {
        display("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static String inputParticipant() {
        display("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}