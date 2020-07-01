package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자로 변환할 수 없는 문자입니다.";

    public static List<String> splitNames(String input){
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public static int toInteger(String input) {

        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
        return number;
    }
}
