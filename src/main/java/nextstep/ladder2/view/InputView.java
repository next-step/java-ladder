package nextstep.ladder2.view;

import java.util.Scanner;

public class InputView {

    public static String getName(Scanner sc) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public static String getResults(Scanner sc) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public static int getHeight(Scanner sc) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.valueOf(sc.nextLine());
    }

    public static String inputName(Scanner sc) {
        System.out.println("결과를 보고 싶은 사람은? ('all' 입력시 전체조회후 종료)");
        return sc.nextLine();
    }
}
