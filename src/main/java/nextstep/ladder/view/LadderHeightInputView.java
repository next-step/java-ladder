package nextstep.ladder.view;

import java.util.Scanner;

public class LadderHeightInputView extends AbstractView{

    private static final Scanner scanner = new Scanner(System.in);
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    public static int getLadderHeight() {
        stringBuilder.append(LADDER_HEIGHT_MESSAGE);
        printAndClear();

//        int height = scanner.nextInt();
//        return new LadderHeight(height);
        return scanner.nextInt();
    }
}
