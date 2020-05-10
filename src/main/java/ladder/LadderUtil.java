package ladder;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderUtil {

    private static final String splitterComma = ",";

    public static List<String> splitStringByComma(String text) {
        if(!text.trim().contains(splitterComma)) {
            throw new IllegalSplitCommaException("문자열에서 [,]를 찾을 수 없습니다. 최소 유저 수를 확인하세요.( 최소 유저 : 2명 )");
        }

        return Arrays.stream(text.split(",")).collect(Collectors.toList());
    }
}
