package ladder.domain.line;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinesTest {

    @Test
    @DisplayName("객체 생성")
    void construct() throws Exception {
        //given
        Lines lines = Lines.of(Arrays.asList(Line.of(2)));

        //when
        List<Line> actual = lines.getLines();

        //then
        assertThat(actual).hasSize(1);

    }

    @Test
    @DisplayName("사다리의 높이가 0인 경우")
    void height_is_zero() throws Exception {
        //given
        int height = 0;
        int playersCount = 5;

        //when
        ThrowableAssert.ThrowingCallable actual = () -> Lines.of(height, playersCount);


        //then
        assertThatThrownBy(actual).isInstanceOf(LinesSizeException.class)
                .hasMessage("사다리의 높이는 1 이상 이어야 합니다.");
    }

    /*
    |-----|     |
    |     |-----|
     */
    @ParameterizedTest(name = "시작 위치별 종료 위치 {index} [{arguments}]")
    @CsvSource(value = {
            "0,2",
            "1,0",
            "2,1"
    })
    @DisplayName("시작 위치별 종료 위치")
    void find_index_of_result(int indexOfStart, int expected) throws Exception {
        //given
        Lines lines = Lines.of(Arrays.asList(
                Line.of(true, false),
                Line.of(false, true)
        ));

        //when
        int actual = lines.indexOfResult(indexOfStart);

        //then
        assertThat(actual).isEqualTo(expected);

    }

}
