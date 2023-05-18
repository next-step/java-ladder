package ladder.domain;

import java.util.List;
import java.util.Objects;

import static ladder.utils.StringSplitter.splitStrings;

public class ResultInput {
    private final List<String> input;

    public ResultInput(List<String> input) {
        this.input = input;
    }

    public static ResultInput of(String strings) {
        return new ResultInput(splitStrings(strings));
    }

    public int size() {
        return input.size();
    }

    public String getResultByPosition(int position) {
        return input.get(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultInput resultInput1 = (ResultInput) o;
        return Objects.equals(input, resultInput1.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }
}
