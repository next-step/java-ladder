package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("사다리 길이 생성 확인")
    public void createLadderTest(int ladderSize) throws Exception {
        //given
        int countOfPerson = 5;

        //when
        Ladder ladder = new Ladder(ladderSize, countOfPerson);
        List<Line> lines = ladder.readOnlyLines();

        //then
        assertThat(lines.size()).isEqualTo(ladderSize) ;
    }
}
