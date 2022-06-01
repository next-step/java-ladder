package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("사다리 결과")
public class LadderResultTest {

    private Person person;
    private Winning winning;

    @BeforeEach
    void setUp() {
        person = new Person("pobi,honux,crong,jk");
        winning = new Winning("꽝,5000,꽝,3000", person.countOfPerson());
    }

    public Ladder createLadder(boolean isPoint) {
        return new Ladder(Arrays.asList(new Line(person.countOfPerson(), () -> isPoint)));
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,꽝", "honux,5000", "crong,꽝", "jk,3000"})
    @DisplayName("사다리 결과 확인")
    public void recordTest01(String name, String result) throws Exception {
        // given
        LadderResult record = LadderResult.of(person,winning, createLadder(false));
        // when
        // then
        assertThat(record.resultOfLadder(name)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,5000", "honux,꽝", "crong,3000", "jk,꽝"})
    @DisplayName("사다리 결과 확인 2번째")
    public void recordTest02(String name, String result) throws Exception {
        // given
        LadderResult record = LadderResult.of(person, winning, createLadder(true));
        // when
        // then
        assertThat(record.resultOfLadder(name)).isEqualTo(result);
    }

    @Test
    @DisplayName("잘못된 참여자 예외 확인")
    public void resultExceptionTest() throws Exception {
        // given
        LadderResult record = LadderResult.of(person, winning, createLadder(true));
        // when
        assertThatIllegalArgumentException().isThrownBy(() -> {
           record.resultOfLadder("ddd");
        });
        // then
    }
}
