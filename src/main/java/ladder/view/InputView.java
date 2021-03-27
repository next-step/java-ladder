package ladder.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public String participants(){
        System.out.println("참여할 사람 이름을 입력하세요.");
        return scanner.nextLine();
    }
}
