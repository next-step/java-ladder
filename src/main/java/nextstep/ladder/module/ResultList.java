package nextstep.ladder.module;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultList implements Iterable<Result> {
    private final List<Result> results;

    public ResultList(List<String> results) {
        validateResultList(results);
        this.results = results.stream().map(Result::new).collect(Collectors.toList());
    }

    public List<Result> value() {
        return results;
    }

    public int size() {
        return results.size();
    }

    public Result get(int index) {
        return results.get(index);
    }

    @Override
    public Iterator<Result> iterator() {
        return results.iterator();
    }

    private void validateResultList(List<String> results) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("결과 리스트는 비어있을 수 없습니다.");
        }
    }
}