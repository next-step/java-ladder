package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ladder.domain.Ladder;
import ladder.domain.LineNumber;

public class LadderTest {

    @Test
    void 생성_테스트() {
        // given
        int height = 5;
        int countOfPerson = 5;
        Ladder ladder = new Ladder(countOfPerson, height);
        // when & then
        assertThat(ladder.getLadder().size()).isEqualTo(height);
    }

    @Test
    void 높이_유효성_테스트() {
        // given
        int height = 0;
        int countOfPerson = 5;
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ladder(countOfPerson, height));
    }

    @Test
    void 실행_결과_중복_테스트() {
        // given
        Set<LineNumber> lineNumberList = new HashSet<>();
        int height = 5;
        int countOfPerson = 5;
        Ladder ladder = new Ladder(countOfPerson, height);

        // when
        for (int i = 0; i < countOfPerson; i++) {
            lineNumberList.add(ladder.matchResult(LineNumber.valueOf(i)));
        }

        // then
        assertThat(lineNumberList.size()).isEqualTo(countOfPerson);
    }

}
