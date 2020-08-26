package ladder.domain.element;

import ladder.domain.common.Printable;
import org.apache.commons.lang3.StringUtils;

import static com.google.common.base.Preconditions.checkArgument;
import static ladder.domain.common.LadderMessage.BLANK_NAME_MESSAGE;
import static ladder.domain.common.LadderMessage.NAME_LENGTH_MESSAGE;

public class LadderElement implements Printable {

    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public LadderElement(String name) {
        checkArgument(StringUtils.isNotBlank(name), BLANK_NAME_MESSAGE);
        checkArgument(name.length() <= MAX_NAME_LENGTH, NAME_LENGTH_MESSAGE, MAX_NAME_LENGTH);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String print() {
        return String.format("%-" + MAX_NAME_LENGTH + "s", name);
    }
}
