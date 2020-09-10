package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResultMapper {

    private static final String ERR_PARTICIPANT_NAME = "참여자 이름을 정확히 입력해 주세요.";

    private Map<String, String> resultMap = new LinkedHashMap<>();

    public LadderResultMapper(LadderResult ladderResult, Participants participants, Rewards rewards) {

        for (int i = 0; i < participants.getPlayerCount(); i++) {
            String person = participants.getNames().get(i);
            String result = rewards.getNames().get(ladderResult.get(i));
            resultMap.put(person, result);
        }

        resultMap = Collections.unmodifiableMap(resultMap);
    }

    public String get(String name) {
        return resultMap.getOrDefault(name, ERR_PARTICIPANT_NAME);
    }

    public List<String> getAll() {
        return resultMap.entrySet()
                        .stream()
                        .map(entry -> entry.getKey() + " : " + entry.getValue())
                        .collect(Collectors.toList());
    }
}
