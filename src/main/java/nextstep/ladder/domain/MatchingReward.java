package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchingReward {

    private Map<String, String> match = new HashMap<>();
    private Location location;
    public MatchingReward(Location location) {
        this.location = location;
    }

    public void line(Person persons, LadderReward results) {
        for (int i = 0; i < persons.size(); i++) {
            match.put(persons.get(i), results.find(location.getter(i)));
        }
    }

    public String result(String want) {
           if (match.get(want) == null)
               throw new IllegalArgumentException("잘못된 사람 이름 입니다");
        return match.get(want);
    }
    public Map<String, String> getMatch() {
        return match;
    }
}
