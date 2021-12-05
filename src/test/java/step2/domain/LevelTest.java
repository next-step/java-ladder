package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LevelTest {

    @Test
    void 단계를_생성한다() {
        //given
        Level level = Level.init();
        //when & then
        assertThat(level).isEqualTo(Level.init());
        assertThat(level.level()).isEqualTo(0);
    }

    @Test
    void 단계를_생성한다2() {
        //given
        Level level = Level.of(3);
        //when & then
        assertThat(level).isEqualTo(Level.of(3));
        assertThat(level.level()).isEqualTo(3);
    }

    @Test
    void 다음_단계로_넘어간다() {
        //given
        Level level = Level.init();
        assertThat(level.level()).isEqualTo(0);
        //when
        level.next();
        //then
        assertThat(level.level()).isEqualTo(1);
    }

    @Test
    void 마지막_단계를_확인한다() {
        //given
        Level level = Level.of(5);
        Level endLevel = Level.of(5);
        //when
        boolean isEnd = level.matched(endLevel);
        //then
        assertThat(isEnd).isTrue();
    }
}
