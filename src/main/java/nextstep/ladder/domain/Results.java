package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    List<String> results = new ArrayList<>();

    public Results(String[] results, int size) {
        if (results.length != size) {
            throw new IllegalArgumentException("참여할 사람 수만큼 결과를 입력해 주세요.");
        }

        for (String result : results) {
            this.results.add(result.trim());
        }
    }

    public List<String> getResults() {
        return results;
    }

    public String getResult(int playerNumber) {
        return results.get(playerNumber);
    }

}
