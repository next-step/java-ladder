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

    @Test
    public void 이동가능한_라인_있는_경우_인접_인덱스로_이동() {
        Line line = Line.initialize(Participants.fromInput("aaa,bbb"), () -> true);

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    public void 이동가능한_라인_없는_경우_인덱스_그대로_반환() {
        Line line = Line.initialize(Participants.fromInput("aaa,bbb"), () -> false);

        assertThat(line.move(0)).isEqualTo(0);
        assertThat(line.move(1)).isEqualTo(1);
    }
}