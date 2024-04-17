package ladder.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputService {
    public static List<String> parseParticipants(String input) {
        return Arrays.stream(input.replaceAll("\\s", "")
                .split(",")).map(InputService::validateParticipants).collect(Collectors.toList());
    }

    private static String validateParticipants(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 다섯글자를 넘길 수 없습니다.");
        }

        return input;
    }

    public static int validateLadderHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1보다 작을 수 없습니다.");
        }

        return height;
    }
}
