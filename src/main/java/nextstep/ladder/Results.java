package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private List<Result> results;

    public Results(List<Result> results){
        this.results = results;
    }

    public List<Result> getResultByUsername(String username) {
        return null;
    }

    public int getSize(){
        return results.size();
    }
}
