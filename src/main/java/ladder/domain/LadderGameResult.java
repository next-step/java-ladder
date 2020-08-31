package ladder.domain;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class LadderGameResult {
    private static final String INVALID_PARTICIPANT_MESSAGE = "존재하지 않는 참가자입니다.";

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

        return Optional.ofNullable(result.get(wishParticipantName))
                .orElse(INVALID_PARTICIPANT_MESSAGE);
    }

    public Map<Name, String> getResult() {
        return result;
    }
}
