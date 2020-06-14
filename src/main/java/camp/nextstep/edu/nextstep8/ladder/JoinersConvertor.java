package camp.nextstep.edu.nextstep8.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JoinersConvertor {
    private static int MAX_NAME_LENGTH = 5;
    private static final String EMPTY = "";
    private static final String SEPARATOR = ",";

    private JoinersConvertor() {}

    public static List<String> makeJoiners(String input) {
        validateEmpty(input);
        return Arrays.stream(input.split(SEPARATOR))
                .map(name -> validateName(name))
                .distinct()
                .collect(Collectors.toList());
    }

    private static void validateEmpty(String str) {
        if(Objects.isNull(str) || EMPTY.equals(str)) {
            throw new IllegalArgumentException("참가자가 없습니다");
        }
    }

    private static String validateName(String name) {
        if(MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("최대 글자 수를 초과 하였습니다 : " + name);
        }
        return name;
    }
}
