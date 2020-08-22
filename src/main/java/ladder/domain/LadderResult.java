package ladder.domain;

import org.apache.commons.lang3.StringUtils;

import static com.google.common.base.Preconditions.checkArgument;
import static ladder.domain.LadderMessage.LADDER_RESULT_MESSAGE;

public class LadderResult implements Printable {

    public static final int MAX_NAME_LENGTH = 5;

    public final String result;

    public LadderResult(String result) {
        checkArgument(StringUtils.isNotBlank(result), LADDER_RESULT_MESSAGE);
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String print() {
        return String.format("%-" + MAX_NAME_LENGTH + "s", result);
    }
}
