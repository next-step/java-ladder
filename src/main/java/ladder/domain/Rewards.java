package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    public static final String RESULT_DELIMITER = ",";

    List<Reward> results = new ArrayList<>();

    public Rewards(String ladderResults) {
        this.results = Arrays.stream(ladderResults.split(RESULT_DELIMITER))
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public int getResultCount() {
        return results.size();
    }

    public String getRewardInfo(int index) {
        return results.get(index).getRewardInfo();
    }

}
