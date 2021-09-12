package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String LADDER_GAME_PRIZE_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String PLAYER_RESULT_MESSAGE = "결과를 보고싶은 사람은?";

    private static final String BLANK_SPACE = " ";
    private static final String EMPTY_STRING = "";
    private static final String COMMA = ",";

    private static final Scanner scanner = new Scanner(System.in);


    public static String[] askPlayerNames() {
        System.out.println(PLAYER_NAMES_MESSAGE);
        String playerNameString = scanner.next().replaceAll(BLANK_SPACE, EMPTY_STRING);
        return playerNameString.split(COMMA);
    }

    public static int askLadderHeight() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
        return scanner.nextInt();
    }

    public static String[] askLadderGamePrizes() {
        System.out.println(LADDER_GAME_PRIZE_MESSAGE);
        String ladderGamePrizesString = scanner.next().replaceAll(BLANK_SPACE, EMPTY_STRING);
        return ladderGamePrizesString.split(COMMA);
    }

    public static String askPlayerNameForResult() {
        System.out.println(PLAYER_RESULT_MESSAGE);
        return scanner.next();
    }

}
