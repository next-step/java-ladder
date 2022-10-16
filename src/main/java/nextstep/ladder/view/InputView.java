package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class InputView {
    private static final String PEOPLE_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REWARDS_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_LENGTH_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 형식의 입력을 수행하셨습니다.";
    private static final String TARGET_PERSON_NAME_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> getPeopleNames() {
        return wrapMethod(this::doGetPeopleNames);
    }

    public List<String> getRewards() {
        return wrapMethod(this::doGetRewards);
    }

    public int getLadderLength() {
        return wrapMethod(this::doGetLadderLength);
    }

    public String getTargetPersonName() {
        return wrapMethod(this::doGetTargetPersonName);
    }

    private List<String> doGetPeopleNames() {
        System.out.println(PEOPLE_NAMES_INPUT_MESSAGE);
        String[] peopleNames = scanner.nextLine().split(",");
        System.out.println();
        return Arrays.asList(peopleNames);
    }

    private List<String> doGetRewards() {
        System.out.println(REWARDS_INPUT_MESSAGE);
        String[] rewards = scanner.nextLine().split(",");
        System.out.println();
        return Arrays.asList(rewards);
    }

    private int doGetLadderLength() {
        System.out.println(LADDER_LENGTH_INPUT_MESSAGE);
        int ladderLength = scanner.nextInt();
        System.out.println();
        return ladderLength;
    }

    private String doGetTargetPersonName() {
        System.out.println(TARGET_PERSON_NAME_INPUT_MESSAGE);
        clearBuffer();
        String targetPersonName = scanner.nextLine();
        System.out.println();
        return targetPersonName;
    }

    private <T> T wrapMethod(Supplier<T> method) {
        try {
            return method.get();
        } catch (Exception e) {
            throw new RuntimeException(INVALID_INPUT_MESSAGE);
        }
    }

    private void clearBuffer() {
        scanner.nextLine();
    }
}
