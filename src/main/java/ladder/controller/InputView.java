package ladder.controller;

import ladder.domain.Member;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static InputView INSTANCE = null;
    private final Scanner SCANNER = new Scanner(System.in);

    public InputView() {
    }

    public static InputView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InputView();
        }
        return INSTANCE;
    }

    public List<Member> getPlayMembers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map(Member::new)
                .collect(Collectors.toList());
    }

    public int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }
}
