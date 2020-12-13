package nextstep.step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Results {

    private static final String COMMA = ",";
    private static final int ZERO = 0;

    private final List<Result> resultList;

    private Results(List<Result> resultList) {
        this.resultList = resultList;
    }

    public static Results initResults(int userNumbers, String results) {
        String[] split = results.split(COMMA);

        validateNumbers(userNumbers, split.length);

        List<Result> resultList = new ArrayList<>(split.length);

        int index = ZERO;
        for(String result : split) {
            resultList.add(Result.of(index++, result));
        }

        return new Results(resultList);
    }

    private static void validateNumbers(int userNumbers, int length) {
        if(userNumbers != length) {
            throw new IllegalArgumentException("참가자 수와 결과 수는 같아야 합니다.");
        }
    }


    public static Results from(List<Result> resultList) {
        return new Results(resultList);
    }

    public Result confirmResult(int finalIndex) {
        return resultList.get(finalIndex);
    }

    public List<Result> getResultList() {
        return resultList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results = (Results) o;
        return Objects.equals(resultList, results.resultList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultList);
    }
}
