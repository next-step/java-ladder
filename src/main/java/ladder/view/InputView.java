package ladder.view;

import java.util.Scanner;

public class InputView {
    private final static String MESSAGE_PLAYERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String MESSAGE_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private final static String DELIMITER_COMMA = ",";
    private final static Scanner scanner = new Scanner(System.in);

    private InputView(){}

    public static String[] enterPlayers(){
        System.out.println(MESSAGE_PLAYERS);
        String[] players = scanner.nextLine().split(DELIMITER_COMMA);
        return players;
    }

    public static int enterHeight(){
        System.out.println();
        System.out.println(MESSAGE_HEIGHT);
        return scanner.nextInt();
    }

}
