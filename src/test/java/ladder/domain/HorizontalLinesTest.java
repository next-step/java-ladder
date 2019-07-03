package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class HorizontalLinesTest {
    Names names = Names.of("1,2,3");
    VerticalLines verticalLines;
    HorizontalLines horizontalLines;

    @BeforeEach
    void setUp() {
        Participants participants = Participants.of(names);
        verticalLines = new VerticalLines(participants.size());
        horizontalLines = HorizontalLines.of(verticalLines);
    }

    @Test
    @DisplayName("HorizontalLines 는 VerticalLines 을 인자로 받아 of 로 생성한다")
    void of() {
        assertThat(horizontalLines.size()).isEqualTo(names.size());
    }

    @Test
    @DisplayName("List<boolean> 을 받아 알맞은 값으로 초기화된 HorizontalLines 를 반환한다")
    void of2() {
        HorizontalLine trueLine = HorizontalLine.of(true);
        HorizontalLine falseLine = HorizontalLine.of(false);
        List<Boolean> booleans = Arrays.asList(false, true, false, true);
        horizontalLines = HorizontalLines.of(booleans);

        assertThat(horizontalLines.getHorizontalLines()).containsExactly(falseLine, trueLine, falseLine, trueLine);
    }

    @Test
    @DisplayName("0번째 boolean 이 true 인 List<boolean> 을 받으면 에러 발생")
    void of3() {
        List<Boolean> booleans = Arrays.asList(true, false);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                HorizontalLines.of(booleans)
        );
    }

    @Test
    @DisplayName("연속으로 true 값이 있는 List<boolean> 을 받으면 에러 발생")
    void of4() {
        List<Boolean> booleans = Arrays.asList(false, true, true);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                HorizontalLines.of(booleans)
        );
    }
}
