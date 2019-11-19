package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spots {

    private final int SPOT_MIN_NUM = 2;

    private List<String> users;
    private List<String> endings;

    public Spots(String nameText, String endingText) {
        List<String> users = createSpots(nameText);
        List<String> endings = createSpots(endingText);

        if (!isValidSpotPair(users, endings)) {
            throw new IllegalArgumentException("참여자 수와 결과 수는 같아야합니다.");
        }

        this.users = users;
        this.endings = endings;
    }

    private List<String> createSpots(String baseString) {
        List<String> spots = Arrays.asList(baseString.split(","));
        if (!isValidSpot(spots) || spots.size() < SPOT_MIN_NUM) {
            throw new IllegalArgumentException("참가자명과 결과명에 공란이 들어갈수 없습니다.");
        }
        return spots;
    }

    private boolean isValidSpot(List<String> spots) {
        return spots.stream()
                .filter(string -> string == null || "".equals(string.trim()))
                .count() == 0;
    }

    private boolean isValidSpotPair(List<String> users, List<String> endings) {
        return (users.size() == endings.size());
    }

    public int getSpotSize() {
        return this.users.size();
    }

    public Map<String, String> useLadder(Ladder ladder) {
        Map<String, String> result = new HashMap<>();
        for(int i=0; i<users.size(); i++){
            result.put(users.get(i), endings.get(ladder.calculateArrival(i)));
        }
        return result;
    }
}
