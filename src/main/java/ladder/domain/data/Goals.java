package ladder.domain.data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Goals {

    List<Goal> goals;

    public Goals(String[] names) {
        this(Arrays.stream(names)
            .collect(Collectors.toList())
        );
    }

    public Goals(List<String> names) {
        this.goals = names.stream()
            .map(Goal::new)
            .collect(Collectors.toList());
    }

    public Goal get(int index) {
        return goals.get(index);
    }
}
