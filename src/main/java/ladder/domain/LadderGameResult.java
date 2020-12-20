package ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderGameResult {
    private final List<String> enteredResults;
    private final Map<String, String> results;

    public LadderGameResult(LadderGameInformation information, List<Integer> ladderResult) {
        this.enteredResults = information.getResults();
        this.results = result(information, ladderResult);
    }

    private Map<String, String> result(LadderGameInformation information, List<Integer> ladderResult) {
        Map<String, String> result = new LinkedHashMap<>();

        IntStream.range(0, information.getParticipantsCount())
                .forEach(position ->
                        result.put(
                                information.getParticipants().get(position),
                                information.getResults().get(ladderResult.get(position))
                        ));

        return result;
    }

    public Map<String, String> getResults() {
        return results;
    }

    public List<String> getEnteredResult() {
        return this.enteredResults;
    }

    public List<String> getParticipants() {
        return new ArrayList<>(results.keySet());
    }
}
