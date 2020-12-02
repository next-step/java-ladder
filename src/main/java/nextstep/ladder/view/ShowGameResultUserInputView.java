package nextstep.ladder.view;

import java.util.Scanner;

public class ShowGameResultUserInputView extends AbstractView{

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SHOW_GAME_RESULT_USER_MESSAGE = "결과를 보고 싶은 사람은?";

    public static String getShowGameResultUser() {
        stringBuilder.append(SHOW_GAME_RESULT_USER_MESSAGE);
        printAndClear();

        return scanner.nextLine();
    }

}
