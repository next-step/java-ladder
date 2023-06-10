package ladder.present;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Scene;
import ladder.domain.User;
import ladder.domain.Users;
import ladder.utils.LineStrategy;
import ladder.utils.LineStrategyRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RendererTest {

    @DisplayName("랜더링이 잘 되는지 검증한다")
    @Test
    public void ladderRendering() {
        //given
        Users users = new Users(
                List.of(
                        new User("a"),
                        new User("b"),
                        new User("c")
                )
        );
        Ladder ladder = Ladder.of(
                Set.of(
                        new Line(0, 0),
                        new Line(1, 1),
                        new Line(2, 2)
                )
        );
        List<String> expect = List.of(
                "|------|      |      |      ",
                "|      |------|      |      ",
                "|      |      |------|      ",
                "|      |      |      |      "
        );
        Renderer renderer = new Renderer(4, 4, ladder, users);
        //when
        Scene scene = renderer.renderingSceneWithUser();
        List<String> actual = scene.getLadderArea();
        //then
        assertAll("sdfs",
                () -> assertThat(expect)
                        .as("동일한 원소 갯수 인지를 검증한다")
                        .hasSize(actual.size()),
                () -> assertThat(IntStream.range(0, expect.size()))
                        .as("모든 원소가 동일한지 검증한다")
                        .allMatch(index -> expect.get(index).equals(actual.get(index))),
                () -> IntStream.range(0, expect.size()).forEach(index -> {
                    assertThat(expect.get(index))
                            .as("개별 원소가 동일한지 검증한다")
                            .isEqualTo(actual.get(index));
                })
        );
    }

    public static class LineStrategyRandomTest {

        private final LineStrategy lineStrategy = LineStrategyRandom.ofLimit(10, 555);

        @DisplayName("지정한 Limit 범위 내로 값이 생성된다")
        @RepeatedTest(300)
        public void randomRange() {
            //given
            //when
            //then
            assertAll("랜덤값 생성을 검증한다",
                    () -> assertThat(lineStrategy.anyColumn()).as("범위 내에서만 Column 랜덤 값을 생성한다").isBetween(0, 10),
                    () -> assertThat(lineStrategy.anyRow()).as("범위 내에서만 Row 랜덤 값을 생성한다").isBetween(0, 555)
            );
        }
    }
}