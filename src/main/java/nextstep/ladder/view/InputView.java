package nextstep.ladder.view;

import nextstep.ladder.dto.LadderRequestDto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static LadderRequestDto inputLadderRequestDto() {
        return new LadderRequestDto(inputNames(), inputLadderHeight());
    }

    private static List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = SCANNER.next();
        return Arrays.asList(names.split(","));
    }

    private static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return SCANNER.nextInt();
    }
}
