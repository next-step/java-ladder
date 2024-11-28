package nextstep.ladder.dto;

import static nextstep.ladder.util.StringUtil.convert;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.ladder.dto.validation.CommaSeparatedResultValidator;

public class CommaSeparatedResult {

    private static final String SPLIT_PATTERN = ",";
    private final List<Value> values;

    private CommaSeparatedResult(List<String> values) {
        validValues(values);
        this.values = List.copyOf(toValues(values));
    }

    private void validValues(List<String> values) {
        CommaSeparatedResultValidator validator = validator();
        validator.valid(values);
    }

    protected CommaSeparatedResultValidator validator() {
        return new CommaSeparatedResultValidator();
    }

    private static List<Value> toValues(List<String> names) {
        return names.stream().map(Value::new).collect(Collectors.toList());
    }

    public CommaSeparatedResult(String value) {
        this(convert(value, SPLIT_PATTERN));
    }

    public final boolean isSameSize(CommaSeparatedResult commaSeparatedResult) {
        return commaSeparatedResult.size() == size();
    }

    public final List<String> getValuesByString() {
        return this.values.stream().map(Value::getName).collect(Collectors.toList());
    }

    public final int size() {
        return values.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommaSeparatedResult commaSeparatedResult1 = (CommaSeparatedResult) o;
        return Objects.equals(values, commaSeparatedResult1.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
