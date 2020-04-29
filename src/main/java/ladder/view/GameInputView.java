package ladder.view;

import java.util.Scanner;

public class GameInputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String GET_PERSON_TO_RESULT_NOTICE = "\n결과를 보고 싶은 사람은?";

    public static String getPersonToGetResult() {
        System.out.println(GET_PERSON_TO_RESULT_NOTICE);

        return scanner.nextLine();
    }
}
