package nextstep.ladder.ui;

import java.util.Scanner;

public class InputView {

    public static Scanner SCANNER = new Scanner(System.in);

    public static String inputNameOfPerson(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return SCANNER.nextLine();
    }

    public static int inputLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }
}
