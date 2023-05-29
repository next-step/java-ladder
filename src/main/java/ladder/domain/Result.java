package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private static final String RESULT_REX_PATTERN = ",";

    private final List<LadderReward> values;

    public Result(String values) {
        this.values = Arrays.asList(values.split(RESULT_REX_PATTERN))
                .stream()
                .map(LadderReward::new)
                .collect(Collectors.toList());
    }

    public String getValue(int index) {
        return values.get(index).getReward();
    }

    public List<LadderReward> getValues() {
        return Collections.unmodifiableList(values);
    }

}
