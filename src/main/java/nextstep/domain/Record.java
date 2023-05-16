package nextstep.domain;

import java.util.HashMap;
import java.util.Map;

public class Record {

    private final Map<Participant, String> record = new HashMap<>();

    public void add(Participant participant, String result) {
        record.put(participant, result);
    }

    public Map<Participant, String> value(String name) {
        if (name.equals("all")) {
            return record;
        }

        Map<Participant, String> resultMap = new HashMap<>();
        Participant key = new Participant(name);
        String value = record.get(key);

        resultMap.put(key, value);

        return resultMap;
    }
}
