package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public String initPerson() {
        System.out.println("참여할 사람 이름을 입력하세요.");
        return sc.nextLine();
    }

    public int maxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return sc.nextInt();
    }
}
