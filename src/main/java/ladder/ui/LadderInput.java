package ladder.ui;

import java.util.Scanner;

import static ladder.ui.LadderDisplay.display;

public class LadderInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputParticipants(){
        display("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        display("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
