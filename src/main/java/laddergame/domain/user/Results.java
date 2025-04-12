package laddergame.domain.user;

import java.util.Arrays;
import java.util.List;

import static laddergame.domain.user.Users.DELIMETER;

public class Results {
    private final List<String> results;

    public Results(String resultsString, int userCount) {
        this.results = Arrays.asList(resultsString.split(DELIMETER));
        validate(userCount);
    }

    private void validate(int userCount) {
        if (userCount != results.size()) {
            throw new IllegalArgumentException("참여하는 사람의 수와 실행 결과의 개수가 맞지 않습니다.");
        }
    }

    public List<String> getResults() {
        return results;
    }

    public String getResult(Integer index) {
        return results.get(index);
    }
}
