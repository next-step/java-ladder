package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_MAX_LADDER= "최대 사다리 높이는 몇 개인가요?";

    public static final Scanner scanner = new Scanner(System.in);

    public String inputName() {
        System.out.print(INPUT_NAME);
        return scanner.nextLine();
    }

    public int inputMaxLadder() {
        System.out.print(INPUT_MAX_LADDER);
        int bonus = scanner.nextInt();
        scanner.nextLine(); // 남은 개행 문자 처리
        return bonus;
    }
}
