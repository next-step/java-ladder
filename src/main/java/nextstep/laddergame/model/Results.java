package nextstep.laddergame.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Results {

    private final Map<Participant, Goal> results = new HashMap<Participant, Goal>();

    public void add(Participant participant, Goal goal) {
        results.put(participant, goal);
    }

    public List<Entry<Participant, Goal>> getAll() {
        return new ArrayList<>(results.entrySet());
    }

    public Goal get(Participant participant) {
        return results.get(participant);
    }
}
