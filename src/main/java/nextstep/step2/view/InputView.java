package nextstep.step2.view;

import nextstep.step2.dto.LadderInformation;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public LadderInformation inputLadderInformation() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String namesString = scanner.nextLine();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String heightString = scanner.nextLine();

        return LadderInformation.create(namesString, heightString);
    }
}
