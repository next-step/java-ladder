package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.Arrays;
import java.util.List;

public final class CommaSeparator implements StringsProvider {

    private static final String DEFAULT_DELIMITER = ",";

    private final String string;

    private CommaSeparator(String string) {
        Assert.hasText(string, "string to split must be provided");
        this.string = string;
    }

    public static CommaSeparator from(String string) {
        return new CommaSeparator(string);
    }

    @Override
    public List<String> strings() {
        return Arrays.asList(string.split(DEFAULT_DELIMITER));
    }

}
