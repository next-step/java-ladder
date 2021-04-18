package ladder.view;

import ladder.controller.dto.LadderGameRequest;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public LadderGameRequest inputLadderGeneration() {
        return new LadderGameRequest(inputParticipants(), inputGameResults(), inputLadderHeight());
    }

    private String inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.next();
    }

    private String inputGameResults() {
        System.out.println(System.lineSeparator() + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.next();
    }

    private int inputLadderHeight() {
        System.out.println(System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public String inputInquiryTargetName() {
        System.out.println(System.lineSeparator() + "결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}
