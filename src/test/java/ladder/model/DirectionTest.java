package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
public class DirectionTest {

    @Test
    void 같은지_비교(){
        assertThat(Direction.of(false,false)).isEqualTo(Direction.of(false,false));
    }

    @Test
    void 라인은_겹치면_오류발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> Direction.of(true,true)
                ).withMessageContaining("라인은 겹치면 안됩니다.");
    }

    @Test
    void 처음은_왼쪽이_FALSE(){
        Direction first = Direction.first(false);
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    void 현재_오른쪽과_다음_왼쪽이_연결되지_않음(){
        Direction next = Direction.first(false).next(true);
        assertThat(next).isEqualTo(Direction.of(false,true));
    }

    @Test
    void 현재_오른쪽과_다음_왼쪽이_연결(){
        Direction next = Direction.first(true).next(false);
        assertThat(next).isEqualTo(Direction.of(true,false));
    }

    @Test
    void 마지막은_오른쪽이_FALSE(){
        assertThat(Direction.first(true).last()).isEqualTo(Direction.of(true,false));
    }


}
