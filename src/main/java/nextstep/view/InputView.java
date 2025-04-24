package nextstep.view;

import java.util.Scanner;

import nextstep.domain.Names;

/**
 * 입력 클래스
 */
public class InputView {
    private static final int MAX_NAME_LENGTH = 5;
    private final Scanner scanner = new Scanner(System.in);

    /** 참여 인원 입력 */
    public Names getName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String name = scanner.nextLine();
        return new Names(name);
    }

    /** 사다리 높이 */
    public int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        return height;
    }

}
