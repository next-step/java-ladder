package ladder.domain;

import ladder.exception.InvalidResultSizeException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private static final String VALIDATE_SIZE = "실행 결과는 참여자 수와 같아야 합니다.";

    private final List<Result> resultList = new ArrayList<>();

    public Results(Players players, List<String> inputResultList) {
        if (inputResultList.size() != players.playerSize()) {
            throw new InvalidResultSizeException(VALIDATE_SIZE);
        }
        inputResultList.forEach((result) -> this.resultList.add(new Result(result)));
    }

    public String findName(int playerIndex) {
        return resultList.get(playerIndex)
                .getResult();
    }

    public List<String> results() {
        return resultList.stream()
                .map(Result::getResult)
                .collect(Collectors.toList());
    }
}
