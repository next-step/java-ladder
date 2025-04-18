package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ResultMapping {
    private final Map<String, String> mapping;

    public ResultMapping(Participants participants, Ladder ladder, Results results) {
        this.mapping = createMapping(participants, ladder, results);
    }

    private Map<String, String> createMapping(Participants participants, Ladder ladder, Results results) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < participants.size(); i++) {
            int endIndex = ladder.move(i);
            String result = results.getResult(endIndex).value();
            map.put(participants.getName(i), result);
        }
        return map;
    }

    public String findResult(String name) {
        return mapping.get(name);
    }

    public Set<String> allParticipants() {
        return mapping.keySet();
    }
}

