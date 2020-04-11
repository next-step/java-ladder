package ladder;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderUtil {

    public static List<String> splitStringByComma(String text) {
        if(!text.trim().contains(",")) {
            throw new IllegalSplitCommaException("문자열에서 [,]를 찾을 수 없습니다.");
        }

        return Arrays.stream(text.split(",")).collect(Collectors.toList());
    }
}
