package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    private List<String> results;

    public LadderResults(List<String> results) {
        this.results = results;
    }

    public int ladderResultCount() {
        return results.size();
    }

    public String getResult(int location) {
        return results.get(location);
    }

    @Override
    public String toString() {
        return results.stream().map(result -> {
            if (result.equals("꽝")) {
                return "    꽝 ";
            }
            String tempResult = "     " + result + " ";
            return tempResult.substring(tempResult.length() - 6);
        }).collect(Collectors.joining());
    }
}
