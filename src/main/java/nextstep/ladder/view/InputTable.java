package nextstep.ladder.view;

import nextstep.ladder.util.InputUtil;

import java.util.List;
import java.util.Scanner;

public final class InputTable {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INSERT_PARTICIPANT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private InputTable() {
    }

    public static List<String> insertParticipantNames() {
        System.out.println(INSERT_PARTICIPANT_NAMES);
        return InputUtil.stringSplit(SCANNER.nextLine());
    }
}
