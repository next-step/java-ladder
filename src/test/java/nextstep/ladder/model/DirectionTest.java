package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DirectionTest {
    @DisplayName("우측 방향 생성 테스트")
    @Test
    public void rightDirectionTest() {
        //when
        Direction direction = Direction.right();

        //then
        assertThat(direction.isRight()).isEqualTo(true);
        assertThat(direction.isLeft()).isEqualTo(false);
    }

    @DisplayName("좌측 방향 생성 테스트")
    @Test
    public void leftDirectionTest() {
        //when
        Direction direction = Direction.left();

        //then
        assertThat(direction.isRight()).isEqualTo(false);
        assertThat(direction.isLeft()).isEqualTo(true);
    }

    @DisplayName("무방향 생성 테스트")
    @Test
    public void nonDirectionTest() {
        //when
        Direction direction = Direction.straight();

        //then
        assertThat(direction.isRight()).isEqualTo(false);
        assertThat(direction.isLeft()).isEqualTo(false);
    }

    @DisplayName("양방향 불가 테스트")
    @Test
    public void eachDirectionTest() {
        assertThatIllegalStateException().isThrownBy(() -> {
           Direction.first(true).next(true);
        });
    }
}
