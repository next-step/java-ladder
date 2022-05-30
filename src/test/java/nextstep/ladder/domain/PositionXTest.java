package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.CannotNullOrEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionXTest {
    private PositionX positionX;

    @BeforeEach
    void setUp() {
        this.positionX = new PositionX(2);
    }

    @Nested
    class getFrom_메서드는 {

        @Nested
        class 빈_결과_목록이_주어지면 {

            @Test
            void CannotNullOrEmptyException을_던진다() {
                assertThatThrownBy(() -> positionX.getFrom(List.of()))
                        .isInstanceOf(CannotNullOrEmptyException.class)
                        .hasMessage("null이거나 비어있을 수 없습니다.");
            }
        }

        @Nested
        class 부족한_길이가_주어지면 {

            @Test
            void IllegalArgumentException을_던진다() {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> positionX.getFrom(List.of(new RunResult("꽝"))))
                        .withMessage("길이가 부족합니다.");
            }

        }

        @Nested
        class null혹은_빈값이_주어진경우 {

            @ParameterizedTest
            @NullAndEmptySource
            void IllegalArgumentException을_던진다(List<RunResult> nullOrEmptySource) {
                assertThatThrownBy(() -> positionX.getFrom(nullOrEmptySource))
                        .isInstanceOf(CannotNullOrEmptyException.class)
                        .hasMessage("null이거나 비어있을 수 없습니다.");
            }

        }

        @Nested
        class 충분한_길이의_결과목록이_주어지면 {

            @Test
            void 찾은_결과를_리턴한다() {
                List<RunResult> runResults = List.of(
                        new RunResult("꽝"),
                        new RunResult("3000"),
                        new RunResult("꽝"),
                        new RunResult("5000")
                );

                RunResult actual = positionX.getFrom(runResults);

                assertThat(actual).isEqualTo(new RunResult("꽝"));
            }
        }
    }
}
