package ladder.gilbert.domain.data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ladder.gilbert.domain.exception.LadderException;

public class Goals {

    private final List<Goal> goals;

    public Goals(String... names) {
        this(Arrays.stream(names)
            .collect(Collectors.toList())
        );
    }

    public Goals(List<String> names) {
        validate(names);
        this.goals = names.stream()
            .map(String::trim)
            .map(Goal::new)
            .collect(Collectors.toList());
    }

    private void validate(List<String> names) {
        if (!isValid(names)) {
            throw new LadderException("실행 결과가 공백입니다.");
        }
    }

    private boolean isValid(List<String> names) {
        return names.stream()
            .noneMatch(String::isBlank);
    }

    public Goal get(int index) {
        return goals.get(index);
    }

    @Override
    public String toString() {
        return goals.stream()
            .map(Goal::formatted)
            .collect(Collectors.joining());
    }

}
