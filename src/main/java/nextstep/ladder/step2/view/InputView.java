package nextstep.ladder.step2.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PLAYERS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_COUNT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    private static final Scanner sc = new Scanner(System.in);

    public static String inputPlayers() {
        System.out.println(INPUT_PLAYERS_MESSAGE);
        return sc.nextLine();
    }

    public static int inputLadderCount() {
        System.out.println(INPUT_LADDER_COUNT_MESSAGE);
        return sc.nextInt();
    }
}
