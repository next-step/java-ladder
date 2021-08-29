package ladder.model;

import ladder.model.stub.LadderMovingStub;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "0,0"})
    void 사다리_타고_이동(int start, int end) {
        //given
        /*
        다음과 같은 사다리 만들기.
        |---|
        |---|
         */
        int playerCount = 2;
        int height = 2;
        Ladder ladder = new Ladder(playerCount, height, (num) -> Arrays.asList(false, true));

        //when
        int finalPosition = ladder.moveFrom(start);

        //then
        assertThat(finalPosition).isEqualTo(end);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,2", "1,1", "2,0"})
    void 사다리_타고_이동2(int start, int end) {
        //given
        /*
        다음과 같은 사다리 만들기.
        |---|   |
        |   |---|
        |---|   |
         */
        int playerCount = 3;
        int height = 3;
        Ladder ladder = new Ladder(playerCount, height, new LadderMovingStub());

        //when
        int finalPosition = ladder.moveFrom(start);

        //then
        assertThat(finalPosition).isEqualTo(end);
    }
}
