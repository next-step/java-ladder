package step2.domain;

import step2.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(String str) {
        validationResult(str);

        String[] resultArr = str.split(",");
        List<Result> newResults = new ArrayList<>();
        for (String result : resultArr) {
            Result newResult = new Result(result);
            newResults.add(newResult);
        }
        return new Results(newResults);
    }

    private static void validationResult(String str) {
        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("실행결과는 빈 칸을 입력하실 수 없습니다.");
        }
    }

    public String getResultOfMember(int index) {
        return results.get(index).getResult();
    }

    public List<Result> getResultOfAllMember() {
        List<Result> newResults = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {

        }
    }
}
