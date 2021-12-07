package nextstep.laddergame.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Results {

    private final Map<Participant, Goal> results = new HashMap<Participant, Goal>();

    public void add(Participant participant, Goal goal) {
        results.put(participant, goal);
    }

    public List<Result> getAll() {
        return results.entrySet()
                      .stream()
                      .map(entry -> new Result(entry.getKey(), entry.getValue()))
                      .collect(Collectors.toList());
    }

    public Goal get(Participant participant) {
        return results.get(participant);
    }
}
