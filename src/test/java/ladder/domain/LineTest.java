package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test(expected = IllegalArgumentException.class)
    public void 가로_라인이_겹치는_경우() {
        // given
        // when
        // then
        new Line.Builder()
                .point(true)
                .point(true)
                .build()
        ;
    }

    @Test
    public void 가로_라인이_겹치지_않는_경우() {
        // given
        // when
        final Line line = new Line.Builder()
                .point(true)
                .point(false)
                .point(true)
                .build()
                ;

        // then
        assertThat(line.getLength()).isEqualTo(4);
    }

    @Test
    public void 점_꺼내기() {
        // given
        final int index = 0;
        final Line line = new Line.Builder()
                .point(true)
                .point(false)
                .point(true)
                .build()
                ;

        // when
        final Point point = line.getPoint(index);

        // then
        assertThat(point).isNotNull();
        assertThat(point.getIndex()).isEqualTo(index);
    }

    @Test
    public void 첫_번째_칸에서_출발하여_두_번째_칸으로_이동() {
        // given
        final Line line = new Line.Builder()
                .point(true)
                .build()
                ;

        // when
        final int result = line.startWith(0);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 두_번째_칸에서_출발하여_첫_번째_칸으로_이동() {
        // given
        final Line line = new Line.Builder()
                .point(true)
                .build()
                ;

        // when
        final int result = line.startWith(1);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 첫_번째_칸에서_출발하여_첫_번째_칸으로_이동() {
        // given
        final Line line = new Line.Builder()
                .point(false)
                .build()
                ;

        // when
        final int result = line.startWith(0);

        // then
        assertThat(result).isEqualTo(0);
    }
}