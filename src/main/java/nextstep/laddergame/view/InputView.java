package nextstep.laddergame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final int MAX_PARTICIPANT_NAME_LENGTH = 5;
    private static final String INPUT_SPLIT_REGEX = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> enterParticipantsName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> names = Arrays.stream(SCANNER.nextLine().split(INPUT_SPLIT_REGEX))
                .map(String::trim)
                .collect(Collectors.toList());

        validateNames(names);
        return names;
    }

    public static List<String> enterLadderResult(int ladderCount) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> ladderResults = Arrays.stream(SCANNER.nextLine().split(INPUT_SPLIT_REGEX))
                .map(String::trim)
                .collect(Collectors.toList());

        validateLadderResultInput(ladderCount, ladderResults);
        return ladderResults;
    }

    public static Integer enterLadderMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputInteger();
    }

    private static void validateNames(List<String> names) {
        names.stream().filter(name -> name.length() > MAX_PARTICIPANT_NAME_LENGTH)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("사용자 이름은 최대 5글자까지 부여할 수 있습니다.");
                });
    }

    private static void validateLadderResultInput(int ladderCount, List<String> ladderResults) {
        if (ladderResults.size() > ladderCount) {
            throw new IllegalArgumentException("실행 결과는 사다리 갯수만큼 지정할 수 있습니다.");
        }
    }

    public static String enterParticipantNamesForResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }

    private static Integer inputInteger() {
        int input = SCANNER.nextInt();
        SCANNER.nextLine();
        return input;
    }
}
