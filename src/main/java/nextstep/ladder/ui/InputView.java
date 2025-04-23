package nextstep.ladder.ui;

import java.util.List;
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

    public static String inputLadderResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n");
        return SCANNER.nextLine();
    }

    public static String inputPlayerOrAll() {
        System.out.println("결과를 보고 싶은 사람은?");
        String test = SCANNER.nextLine();
        return SCANNER.nextLine();
    }
}
