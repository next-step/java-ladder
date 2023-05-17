package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getParticipants() {
        return scanner.next();
    }
    
    public static int getLadderHeight() {
        return scanner.nextInt();
    }

    public static String getResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.next();
    }
}
