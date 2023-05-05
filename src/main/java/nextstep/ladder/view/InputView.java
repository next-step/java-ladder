package nextstep.ladder.view;

import nextstep.ladder.domain.Heights;
import nextstep.ladder.domain.Participants;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static Participants inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Participants.from(List.of(SCANNER.nextLine().split(DELIMITER)));
    }

    public static Heights inputHeights() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Heights(SCANNER.nextInt());
    }
}
