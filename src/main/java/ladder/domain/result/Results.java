package ladder.domain.result;

import ladder.domain.user.Participant;
import ladder.domain.user.Participants;

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
        Map<Participant, ExpectedResult> result = participants.stream()
                .collect(Collectors.toMap(Function.identity(), results::get, (x, y) -> y, LinkedHashMap::new));
        return new Results(Collections.unmodifiableMap(result));
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
