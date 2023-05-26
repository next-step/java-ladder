package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Result {

    private static final String RESULT_REX_PATTERN = ",";

    private final List<String> values;

    public Result(String values) {
        this.values = Arrays.asList(values.split(RESULT_REX_PATTERN));
    }

    public String getValue(int index) {
        return values.get(index);
    }

    public List<String> getValues() {
        return Collections.unmodifiableList(values);
    }

}
