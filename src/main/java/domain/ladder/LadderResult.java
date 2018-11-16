package domain.ladder;

import java.util.List;

public class LadderResult {
    private List<String> results;

    LadderResult(List<String> result) {
        this.results = result;
    }


    List<String> getResults() {
        return results;
    }

    String getResult(int location){
        return results.get(location);
    }

}
