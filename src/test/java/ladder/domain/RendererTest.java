package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RendererTest {
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
        Lines lines = new Lines(
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
        Renderer renderer = new Renderer(4, 4, lines, users);
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
}