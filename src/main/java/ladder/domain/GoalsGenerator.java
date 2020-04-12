package ladder.domain;

import Utils.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GoalsGenerator {
    private final String inputText;

    public GoalsGenerator(final String inputText) {
        this.inputText = inputText;
    }

    public LadderGoals generate() {
        Map<Integer, String> map = new HashMap<>();
        List<String> splitText = StringUtils.splitText(inputText);
        int index = 0;

        for (String result : splitText) {
            map.put(index++, result);
        }

        return new LadderGoals(map);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoalsGenerator)) return false;
        GoalsGenerator that = (GoalsGenerator) o;
        return Objects.equals(inputText, that.inputText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputText);
    }
}
