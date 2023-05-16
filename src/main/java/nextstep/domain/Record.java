package nextstep.domain;

import java.util.HashMap;
import java.util.Map;

public class Record {

    private final Map<Participant, String> record = new HashMap<>();

    public void add(Participant participant, String result) {
        record.put(participant, result);
    }
}
