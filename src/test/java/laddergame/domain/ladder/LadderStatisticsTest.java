package laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderStatisticsTest {
    private LadderStatistics statistics;
    private Results results;
    private List<Result> resultList;
    private List<Integer> moveIndexList;
    private int height = 5;
    private int numbers = 4;

    @BeforeEach
    void setUp() {
        Ladder ladder = LadderTest.makeTestLadder(new Size(height, numbers));
        moveIndexList = Arrays.asList(2, 3, 0, 1);
        resultList = Arrays.asList(new Result("꽝"), new Result("1000"), new Result("2000"), new Result("3000"));
        results = new Results(resultList);
        statistics = new LadderStatistics(ladder, results);
    }

    @Test
    @DisplayName("한 가지 인덱스의 결과값을 반환한다.")
    void 결과하나매치() {
        int index = 0;
        assertThat(statistics.matchOne(index)).isEqualTo(resultList.get(moveIndexList.get(index)));
    }

    @Test
    @DisplayName("모든 플레이어의 결과값을 반환한다.")
    void 모든결과매치 () {
        List<Result> predict = new ArrayList<>();
        moveIndexList.forEach(index -> predict.add(resultList.get(index)));
        assertThat(statistics.matchAll(numbers)).isEqualTo(predict);
    }
}
