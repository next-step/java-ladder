package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Height;
import step2.domain.Ladder;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @ParameterizedTest
    @DisplayName("높이, 사람수 지정 후 사다리 출력 갯수 테스트")
    @CsvSource(value = {"5:3", "6:2", "5:4"}, delimiter = ':')
    void countLayersTest(int height, int countOfperson){
        Ladder ladder = Ladder.create(Height.of(height), countOfperson);
        //높이는 사다리 한개 층과 같음.
        assertThat(ladder.getLayers()).hasSize(height);
        //사다리 포인트 정보는 사람수와 같음
        assertThat(ladder.getLayers().get(0).getPoints()).hasSize(countOfperson);
    }
}
