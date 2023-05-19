package nextstep.ladder.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    private Util() {
        throw new AssertionError("Util 클래스의 인스턴스를 생성할 수 없습니다!");
    }

    public static List<String> convertArrayToList(String[] splitResults) {
        return Arrays.stream(splitResults).collect(Collectors.toList());
    }

    public static List<String> separateToList(String participants, String delimiter) {
        return Arrays.stream(participants.split(delimiter))
                .collect(Collectors.toList());
    }
}
