package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderTest {

    @Test
    @DisplayName("사다리를 생성시 파라미터인 Height, personCount를 기반으로 lines의 사이즈, points의 사이즈를 검증한다.")
    void createLadder() {
        int height = 5;
        int personCount = 5;
        Ladder ladder = new Ladder(height, personCount, () -> true);
        List<Line> lines = ladder.lines();
        assertEquals(lines.size(), height);
        lines.stream()
                .forEach(line -> assertEquals(line.points().size(), personCount - 1));
    }

    @Test
    @DisplayName("한 줄 사다리를 만들었을 때 0번 인덱스의 resultOf 함수 결과는 1이다.")
    void resultOf() {
        Ladder ladder = new Ladder(1, 2, () -> true);
        int result = ladder.resultOf(0);
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("한 줄 사다리를 만들었을 때 resultAll 함수의 결과는 1,0 인덱스 순서이다.")
    void resultAll(){
        Ladder ladder = new Ladder(1, 2, () -> true);
        List<Integer> resultAll = ladder.resultAll();
        assertEquals(resultAll.get(0), 1);
        assertEquals(resultAll.get(1), 0);
    }
}