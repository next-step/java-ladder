package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineStrategyRandomTest {

    private LineStrategy lineStrategy = LineStrategyRandom.ofLimit(10, 555);

    @DisplayName("지정한 Limit 범위 내로 값이 생성된다")
    @RepeatedTest(300)
    public void randomRange() {
        //given
        //when
        //then
        assertAll("랜덤값 생성을 검증한다",
                () -> assertThat(lineStrategy.anyColumn()).as("범위 내에서만 Column 랜덤 값을 생성한다").isBetween(0, 10),
                () -> assertThat(lineStrategy.anyRow()).as("범위 내에서만 Row 랜덤 값을 생성한다").isBetween(0, 555)
        );
    }
}