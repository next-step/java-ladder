package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 라인_생성_테스트() {
        Line line = Line.initialize(Participants.fromInput("aaa,bbb"), () -> true);

        assertThat(line.toString()).isEqualTo("     |-----|");
    }

    @Test
    public void 연속한_라인은_나오지_못한다() {
        // 항상 Point 생성하는 strategy 지만 Point 로직에 의해 연속된 라인은 나오지 않는다.
        Line line = Line.initialize(Participants.fromInput("aaa,bbb,ccc,ddd"), () -> true);

        assertThat(line.toString()).isEqualTo("     |-----|     |-----|");
    }
}