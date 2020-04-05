package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
    @Test
    @DisplayName("인접 해서 사다리 바가 있을 수 없음")
    void adjacentTest(){
        assertThatThrownBy(()->Line.of(true,true,false,true))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음 수 일 수 없음")
    void countOver1Test() {
        int personCount = 0;
        assertThatThrownBy(() -> Line.ofCount(personCount))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("count 정상 생성")
    void createCountTest(){
        assertThatCode(()->Line.ofCount(10))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("일반 정상 생성")
    void createBarsTest(){
        assertThatCode(()->Line.of(true,false,true,false))
                .doesNotThrowAnyException();
    }
}
