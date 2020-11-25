package step03.view;

import java.util.Scanner;

public class InputView {
    private static final String TOKEN = ",";
    private static final String PARTICIPANTS_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표("+TOKEN+")로 구분하세요)";
    private static final String HEIGHT_OF_LADDER_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner scanner = new Scanner(System.in);
    private InputView() {}

    public static String readNamesOfParticipants() {
        System.out.println(PARTICIPANTS_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static Integer readCountOfSteps() {
        System.out.println(HEIGHT_OF_LADDER_MESSAGE);
        return scanner.nextInt();
    }

}
