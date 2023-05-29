package ladder.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private List<Result> results = new ArrayList<>();

    public Results(List<String> results) {
        this.results = results
                .stream()
                .map(result -> new Result(result))
                .collect(Collectors.toList());
    }

    public Results(List<String> results, Players players) {
        validateResults(results, players);
        this.results = results
                .stream()
                .map(result -> new Result(result))
                .collect(Collectors.toList());
    }

    public Result getResult(int idx){
        return results.get(idx);
    }

    public List<Result> getResults(){
        return this.results;
    }

    private void validateResults(List<String> results, Players players){
        if(results.size() != players.getCountOrPerson()){
            throw new IllegalArgumentException("결과값 개수는 플레이어수와 동일해야 합니다.");
        }
    }
}
