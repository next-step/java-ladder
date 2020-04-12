package ladder.domain;

import Utils.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ResultGenerator {
    private final String inputText;

    public ResultGenerator(final String inputText) {
        this.inputText = inputText;
    }

    public LadderResult generate() {
        Map<Integer, String> map = new HashMap<>();
        List<String> splitText = StringUtils.splitText(inputText);
        int index = 0;

        for (String result : splitText) {
            map.put(index++, result);
        }

        return new LadderResult(map);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultGenerator)) return false;
        ResultGenerator that = (ResultGenerator) o;
        return Objects.equals(inputText, that.inputText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputText);
    }
}
