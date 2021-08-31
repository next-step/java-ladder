package nextstep.ladder.view;

import nextstep.ladder.util.Validation;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PLAYERS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_COUNT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    private static final String INPUT_GAME_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputPlayers() {
        System.out.println(INPUT_PLAYERS_MESSAGE);
        return Validation.isEmptyAndNull(scanner.nextLine());
    }

    public static String inputResult() {
        System.out.println(INPUT_RESULT_MESSAGE);
        return Validation.isEmptyAndNull(scanner.nextLine());
    }

    public static int inputLadderCount() {
        System.out.println(INPUT_LADDER_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static String inputGameResultSearch() {
        System.out.println(INPUT_GAME_RESULT_MESSAGE);
        scanner.nextLine();
        return scanner.nextLine();
    }
}
