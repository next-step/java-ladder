package nextstep.ladder.view;

import java.util.Scanner;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    public static String askPersonsName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return scanner.nextLine();
    }

    public static int askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return scanner.nextInt();
    }
}
