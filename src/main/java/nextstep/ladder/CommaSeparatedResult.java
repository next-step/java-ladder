package nextstep.ladder;

import java.util.List;
import nextstep.ladder.util.StringUtil;

public class CommaSeparatedResult {
    private static final String SPLIT_PATTERN = ",";

    protected static List<String> convert(String value) {
        return StringUtil.convert(value, SPLIT_PATTERN);
    }
}
