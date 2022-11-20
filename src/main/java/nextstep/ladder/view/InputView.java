package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    public static String askForPlayerNames(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해주세요");
        return scanner.next();
    }
}
