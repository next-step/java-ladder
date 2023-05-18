package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.utils.StringSplitter.splitStrings;
import static org.assertj.core.api.Assertions.assertThat;

class ResultInputTest {
    private String string;
    private List<String> stringList;

    @BeforeEach
    void setUp() {
        string = "꽝,5000,꽝,3000";
        stringList = splitStrings(string);
    }

    @Test
    @DisplayName("실행 결과를 Result 객체에 저장한다")
    void create() {
        // when
        ResultInput resultInput = ResultInput.of(string);

        // then
        assertThat(resultInput).isEqualTo(new ResultInput(stringList));
        assertThat(resultInput.size()).isEqualTo(stringList.size());
    }

    @Test
    @DisplayName("특정 위치의 결과 확인")
    void result() {
        // given
        ResultInput resultInput = ResultInput.of(string);
        int position = 3;

        // when
        String actual = resultInput.getResultByPosition(position);

        // then
        assertThat(actual).isEqualTo("3000");
    }
}