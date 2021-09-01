package step2.model;

import java.util.ArrayList;
import java.util.List;

import static step2.model.LadderValidator.isBlank;

public class Results {
    private List<Result> results;

    public Results(String results, int numberOfUsers) {
        isBlank(results);
        isEqualsNumberOfUsers(results, numberOfUsers);
        setResults(results);
    }

    private void setResults(String results) {
        this.results = new ArrayList<>();

        for (String result : getSplit(results)) {
            this.results.add(new Result(result));
        }
    }

    private String[] getSplit(String results) {
        return results.split(",");
    }

    private void isEqualsNumberOfUsers(String results, int numberOfUsers) {
        if (getSplit(results).length < numberOfUsers) {
            throw new IllegalArgumentException("결과값은 참여자 수만큼 입력해주세요.");
        }
    }
}
