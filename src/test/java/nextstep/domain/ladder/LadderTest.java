package nextstep.domain.ladder;

import nextstep.generator.RandomPointGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderTest {
    private  RandomPointGenerator randomPointGenerator;
    private Ladder ladder;
    @BeforeEach
    void init(){
        randomPointGenerator = new RandomPointGenerator();
        ladder = new Ladder(5, new Height(4), randomPointGenerator);
    }

    @Test
    @DisplayName("생성된 사다리의 높이는 입력받은 높이와 같다.")
    public void checkLadderHeight() {
        assertEquals(ladder.countHeight(), 4);
    }

    @Test
    @DisplayName("사용자의 수보다 모든 line의 point가 하나 적어야한다.")
    public void checkLadderPoint(){
        assertEquals(ladder.countPointsPerLine(), 4);
    }
}