package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class InputView {
    private static final String PEOPLE_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_LENGTH_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 형식의 입력을 수행하셨습니다.";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> getPeopleNames() {
        return wrapMethod(this::doGetPeopleNames);
    }

    public int getLadderLength() {
        return wrapMethod(this::doGetLadderLength);
    }

    private List<String> doGetPeopleNames() {
        System.out.println(PEOPLE_NAMES_INPUT_MESSAGE);
        String[] peopleNames = scanner.nextLine().split(",");
        System.out.println();
        return Arrays.asList(peopleNames);
    }

    private int doGetLadderLength() {
        System.out.println(LADDER_LENGTH_INPUT_MESSAGE);
        int ladderLength = scanner.nextInt();
        System.out.println();
        return ladderLength;
    }

    private <T> T wrapMethod(Supplier<T> method) {
        try {
            return method.get();
        } catch (Exception e) {
            throw new RuntimeException(INVALID_INPUT_MESSAGE);
        }
    }
}
