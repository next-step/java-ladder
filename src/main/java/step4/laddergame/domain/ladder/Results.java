/*
 * 결과 리스트를 담는 클래스
 * */
package step4.laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toCollection;

public class Results {
    private final List<Result> resultList;

    public Results(List<Result> resultList) {
        this.resultList = resultList;
    }

    public static Results of(List<String> resultList) {
        return new Results(resultList.stream()
                .map(result -> Result.of(result))
                .collect(toCollection(ArrayList::new)));
    }

    public List<Result> getResultList() {
        return Collections.unmodifiableList(resultList);
    }

    public Result getOne(int index) {
        return resultList.get(index);
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
