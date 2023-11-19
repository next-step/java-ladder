package nextstep.ladder.input;

import java.util.Scanner;

public class Input {
    public static UserNames inputNames() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String userNamesText = scanner.nextLine();

        return new UserNames(userNamesText);
    }

    public static LadderHeight inputLadderHeight() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = scanner.nextInt();

        return new LadderHeight(ladderHeight);
    }
}
