package step2.view;

import java.util.Scanner;

public class LadderGameInputView implements InputView {
    public static final String QUESTION_JOIN_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)";
    public static final String QUESTION_MAXIMUM_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private final Scanner scanner;

    public LadderGameInputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getPlayerNames() {
        System.out.println(QUESTION_JOIN_PLAYER_NAMES);
        return scanner.nextLine();
    }

    @Override
    public Integer getLadderHeight() {
        System.out.println(QUESTION_MAXIMUM_LADDER_HEIGHT);
        return nextInt();
    }

    private Integer nextInt() {
        return Integer.parseInt(scanner.nextLine());
    }
}
