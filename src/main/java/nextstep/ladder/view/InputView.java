package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    public static String getNames() {
        System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Integer getHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
