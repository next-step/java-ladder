package ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String DELIMITER = ",";
    private static final String ERR_MORE_THEN_TWO_ELEMENT = "2개 이상의 요소를 입력해야 합니다.";
    private static final int MINIMUM_LIST_SIZE = 1;

    public static List<String> splitStringToList(String originalString) {

        verifyEmptyString(originalString);

        List<String> list = Arrays.stream(originalString.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        verifyListSize(list);

        return list;
    }

    private static void verifyEmptyString(String nameStr) {
        if (nameStr == null || nameStr.isEmpty()) {
            throw new IllegalArgumentException(ERR_MORE_THEN_TWO_ELEMENT);
        }
    }

    private static void verifyListSize(List<String> list) {
        if (list.size() <= MINIMUM_LIST_SIZE) {
            throw new IllegalArgumentException(ERR_MORE_THEN_TWO_ELEMENT);
        }
    }
}
