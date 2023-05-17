package nextstep.step2.view;

import nextstep.step2.domain.Participants;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Participants inputParticipantPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return new Participants(SCANNER.nextLine());
    }

    public static int inputLadderHeight() {
        System.out.println(System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?");

        return SCANNER.nextInt();
    }

}
