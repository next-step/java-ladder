package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
    public static final int MAX_NAME_LENGTH = 5;
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getParticipantsName() {
        String[] split = scanner.next().split(DELIMITER);
        validateInput(split);
        return Arrays.stream(split)
                .collect(Collectors.toList());
    }

    private static void validateInput(String[] split) {
        Arrays.stream(split)
                .filter(s -> s.length() > MAX_NAME_LENGTH)
                .findAny()
                .ifPresent(s -> {
                    throw new IllegalArgumentException(s + "는 입력할 수 없습니다.");
                });
    }
    
    public static int getLadderHeight() {
        int height = scanner.nextInt();
        validateHeight(height);
        return height;
    }

    private static void validateHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
