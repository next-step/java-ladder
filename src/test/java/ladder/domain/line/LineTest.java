package ladder.domain.line;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LineTest {

    private final Line defaultLine = Line.valueOf(Arrays.asList(true, false, true));

    @Test
    @DisplayName("연속된 라인으로 생성한 경우")
    void can_not_be_consecutive() {
        //given
        List<Boolean> lines = Arrays.asList(Boolean.TRUE, Boolean.TRUE);

        //when
        ThrowingCallable actual = () -> Line.valueOf(lines);

        //then
        assertThatThrownBy(actual).isInstanceOf(LineContinuousException.class)
                .hasMessage("라인은 연속되어 생성될 수 없습니다.");

    }


    @ParameterizedTest(name = "참가자 수에 따른 라인 수 {index} [{arguments}]")
    @CsvSource(value = {
            "4,3",
            "2,1"
    })
    @DisplayName("참가자 수에 따른 라인 수")
    void line_size(int playersCount, int expected) {
        //given
        Line line = Line.of(playersCount);

        //when
        int actual = line.size();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    /*
    |-----|     |
     */
    @ParameterizedTest(name = "시작위치에 따른 종료위치 {index} [{arguments}]")
    @CsvSource(value = {
            "0,1",
            "1,0",
            "2,2"
    })
    @DisplayName("시작위치에 따른 종료위치")
    void indexOfResult(int indexOfStart, int expected) {
        //given
        Line line = Line.valueOf(Arrays.asList(true, false));

        //when
        int actual = line.indexOfResult(indexOfStart);

        //then
        assertThat(actual).isEqualTo(expected);
    }

}
