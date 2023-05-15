package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.utils.StringSplitter.splitStrings;
import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private String string;
    private List<String> stringList;

    @BeforeEach
    void setUp() {
        string = "꽝,5000,꽝,3000";
        stringList = splitStrings(string);
    }

    @Test
    @DisplayName("결과를 입력받아 저장한다")
    void create() {
        // when
        Result result = new Result(string);

        // then
        assertThat(result).isEqualTo(new Result(stringList));
    }

    @Test
    @DisplayName("특정 위치의 결과 확인")
    void result() {
        // given
        Result result = new Result(string);
        int position = 3;

        // when
        String actual = result.getResultByPosition(position);

        // then
        assertThat(actual).isEqualTo("3000");
    }

    @Test
    @DisplayName("전체 결과 확인")
    void resultAll() {
        // given
        Result result = new Result(string);
        List<Integer> positions = List.of(0, 1, 2, 3);

        // when
        List<String> actual = result.getResultByPositions(positions);

        // then
        assertThat(actual).isEqualTo(stringList);
    }

}