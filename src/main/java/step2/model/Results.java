package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static step2.model.LadderValidator.isBlank;

public class Results {
    private List<Result> results;

    public Results(String results, int numberOfUsers) {
        isBlank(results);
        isEqualsNumberOfUsers(results, numberOfUsers);
        saveResults(results);
    }

    public Results(List<Result> results) {
        this.results = results;
    }

    private void saveResults(String results) {
        this.results = new ArrayList<>();

        for (String result : splitResults(results)) {
            this.results.add(new Result(result));
        }
    }

    private String[] splitResults(String results) {
        return results.split(",");
    }

    private void isEqualsNumberOfUsers(String results, int numberOfUsers) {
        if (splitResults(results).length < numberOfUsers) {
            throw new IllegalArgumentException("결과값은 참여자 수만큼 입력해주세요.");
        }
    }

    public List<String> getResultList() {
        return results.stream()
                .map(Result::getResult)
                .collect(Collectors.toList());
    }

    public Result getResult(int index) {
        return results.get(index);
    }
}
