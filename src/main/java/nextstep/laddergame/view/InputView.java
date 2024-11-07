package nextstep.laddergame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final int MAX_PARTICIPANT_NAME_LENGTH = 5;
    private static final String PARITICIPANTS_SPLIT_REGEX = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> enterParticipantsName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split(PARITICIPANTS_SPLIT_REGEX))
                .map(String::trim)
                .collect(Collectors.toList());

        validateNames(names);
        return names;
    }

    private static void validateNames(List<String> names) {
        names.stream().filter(name -> name.length() > MAX_PARTICIPANT_NAME_LENGTH)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("사용자 이름은 최대 5글자까지 부여할 수 있습니다.");
                });
    }

    public static Integer enterLadderMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
