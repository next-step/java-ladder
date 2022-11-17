package ladder.domain;

import ladder.exception.InvalidResultSizeException;

import java.util.List;

public class Results {
    private static final String VALIDATE_SIZE = "실행 결과는 참여자 수와 같아야 합니다.";

    private final List<String> resultList;

    public Results(int size, List<String> resultList) {
        if (resultList.size() != size) {
            throw new InvalidResultSizeException(VALIDATE_SIZE);
        }
        this.resultList = resultList;
    }
}
