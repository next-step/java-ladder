package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Results {
    private Map<String, Result> resultsByName;

    public Results(List<String> playerNames, String inputResults) {
        if (inputResults == null || inputResults.trim().isEmpty()) {
            throw new IllegalArgumentException("결과가 없습니다");
        }

        List<String> resultValues = Arrays.stream(inputResults.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        if (playerNames.size() != resultValues.size()){
            throw new IllegalArgumentException("플레이어 수와 결과 수가 일치하지 않습니다.");
        }

        this.resultsByName = new LinkedHashMap<>();
        for(int i=0; i< playerNames.size(); i++){
            resultsByName.put(playerNames.get(i), new Result(resultValues.get(i)));
        }
    }

    public List<Result> getResults() {
        return new ArrayList<>(resultsByName.values());
    }

    public Map<String, Result> getResultsByName() {
        return Collections.unmodifiableMap(resultsByName);
    }

    public Result findByName(String name) {
        Result result = resultsByName.get(name);
        if (result == null) {
            throw new IllegalArgumentException("해당 이름의 결과를 찾을 수 없습니다: " + name);
        }
        return result;
    }
}
