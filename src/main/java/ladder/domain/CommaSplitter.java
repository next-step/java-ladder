package ladder.domain;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import static com.google.common.base.Preconditions.checkArgument;
import static ladder.domain.LadderMessage.BLANK_TEXT_MESSAGE;

public class CommaSplitter {

    public static final String COMMA_DELIMITER = ",";

    public static Iterable<String> split(String str) {
        checkArgument(StringUtils.isNotBlank(str), BLANK_TEXT_MESSAGE);
        return Splitter.on(COMMA_DELIMITER).trimResults().split(str);
    }
}
