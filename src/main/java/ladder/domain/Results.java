package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Results {

    private final Map<Participant, ExpectedResult> results;

    public Results(Map<Participant, ExpectedResult> results) {
        this.results = results;
    }

    public Results getDesireResults(Participants desireParticipants) {
        List<Participant> participants = desireParticipants.getParticipants();
        return new Results(participants.stream()
                .collect(Collectors.toMap(Function.identity(), results::get, (x, y) -> y, LinkedHashMap::new)));
    }

    public boolean isOneResult() {
        return results.size() == 1;
    }

    public ExpectedResult getOnlyOneResult() {
        if (!isOneResult()) throw new IndexOutOfBoundsException("result size is not one");
        return results.values().stream().findAny().get();
    }

    public Map<Participant, ExpectedResult> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
