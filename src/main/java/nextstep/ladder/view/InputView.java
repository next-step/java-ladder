package nextstep.ladder.view;

import nextstep.ladder.domain.Heights;
import nextstep.ladder.domain.LadderInputs;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static LadderInputs inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return LadderInputs.from(List.of(SCANNER.nextLine().split(DELIMITER)));
    }

    public static LadderInputs inputResults(LadderInputs participants) {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return LadderInputs.from(List.of(SCANNER.nextLine().split(DELIMITER)), participants);
    }

    public static Heights inputHeights() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Heights(SCANNER.nextInt());
    }
}
