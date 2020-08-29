package ladder.domain;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class LadderGameResult {
    private Map<Name, String> result;

    private LadderGameResult(Map<Name, String> result) {
        this.result = result;
    }

    public static LadderGameResult of(Map<Name, Integer> resultByName, LadderReward ladderReward) {
        Map<Name, String> result = resultByName.keySet()
                .stream()
                .collect(toMap(Function.identity(), key -> ladderReward.getResultBy(resultByName.get(key))));

        return new LadderGameResult(result);
    }

    public String getBy(String wishParticipant) {
        Name wishParticipantName = Name.from(wishParticipant);

        return result.get(wishParticipantName);
    }

    public Map<Name, String> getResult() {
        return result;
    }
}
