package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static final String BLANK_SPACE = " ";
    private static final String EMPTY_STRING = "";
    private static final String COMMA = ",";

    private final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static InputView getInstance() {
        return InputViewHolder.instance;
    }

    public String[] playerNames() {
        System.out.println(PLAYER_NAMES_MESSAGE);
        String playerNameString = scanner.nextLine().replaceAll(BLANK_SPACE, EMPTY_STRING);
        return playerNameString.split(COMMA);
    }


    public int askLadderHeight() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
        return scanner.nextInt();
    }

    public void closeInputScanner() {
        scanner.close();
    }

    private static class InputViewHolder {

        private static final InputView instance = new InputView();
    }

}
