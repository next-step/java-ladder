package ladder.domain.data;

import java.util.*;
import java.util.stream.Collectors;

public class Goals {

    List<String> goals;

    public Goals(String[] names) {
        this(Arrays.stream(names)
            .collect(Collectors.toList())
        );
    }

    public Goals(List<String> goals) {
        this.goals = new ArrayList<>(goals);
    }
}
