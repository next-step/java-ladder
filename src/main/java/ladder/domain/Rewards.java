package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rewards {

    public static final String RESULT_DELIMITER = ",";

    List<Reward> results = new ArrayList<>();

    public Rewards(String ladderResults) {
        String[] resultArray = ladderResults.split(RESULT_DELIMITER);
        this.results = IntStream.range(0, resultArray.length)
                        .mapToObj(i -> new Reward(resultArray[i]))
                        .collect(Collectors.toList());
    }

    public int getResultCount() {
        return results.size();
    }

    public String getRewardInfo(int index) {
        return results.get(index).getRewardInfo();
    }

}
