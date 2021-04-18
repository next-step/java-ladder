/*
* 사다리타기의 결과를 확인할 수 있는 클래스
* */
package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class LadderStatistics {
    private final Ladder ladder;
    private final Results results;

    public LadderStatistics(Ladder ladder, Results results) {
        this.ladder = ladder;
        this.results = results;
    }

    public Result matchOne(int index) {
        return results.getOne(ladder.move(index));
    }

    public List<Result> matchAll(int length) {
        return IntStream.range(0, length)
                .mapToObj(index -> matchOne(index))
                .collect(toCollection(ArrayList::new));
    }
}
