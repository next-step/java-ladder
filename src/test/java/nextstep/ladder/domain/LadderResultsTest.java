package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultsTest {

    private String input;

    @BeforeEach
    void init() {
        input = "꽝,5000,꽝,3000";
    }

    @Test
    @DisplayName("사다리타리 결과가 정상적으로 생성된다.")
    void createTest() {
        assertThatCode(() -> LadderResults.create(input)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("참가자의 결과가 정상적으로 반환된다.")
    void getTest() {
        LadderResults ladderResults = LadderResults.create(input);
        Participant participant = new Participant("koi", Position.of(1));

        assertThat(ladderResults.get(participant)).isEqualTo("5000");
    }


    @Test
    @DisplayName("일급콜렉션 객체의 List는 외부에서는 불변 리스트 이다.")
    void getResultsUnmodifiableCollectionTest() {
        List<String> results = LadderResults.create(input).getResults();

        assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(() -> results.add("result3"));
    }
}