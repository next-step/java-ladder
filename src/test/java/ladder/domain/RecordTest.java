package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("결과")
public class RecordTest {

    private Person person;
    private Winning winning;

    @BeforeEach
    void setUp() {
        person = new Person("pobi,honux,crong,jk");
        winning = new Winning("꽝,5000,꽝,3000", person.countOfPerson());
    }

    public Ladder createladder(boolean isPoint) {
        return new Ladder(Arrays.asList(
                new Line(person.countOfPerson(), () -> isPoint))
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,꽝","honux,5000","crong,꽝","jk,3000"})
    @DisplayName("결과 확인")
    public void recordTest(String name, String result) throws Exception {
        //given
        Record record = Record.of(person, winning, createladder(false));
        //when
        //then
        assertThat(record.resultOfLadder(name)).isEqualTo(result);
    }
}
