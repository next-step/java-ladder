package ladder.domain.point;

import ladder.core.DirectionGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ladder.domain.point.DirectionValue.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UnconnectedRandomDirectionGeneratorTest {
    private static DirectionGenerator generator;

    @BeforeAll
    public static void setUp() {
        generator = new UnconnectedRandomDirectionGenerator();
    }

    @Test
    @DisplayName("first()는 isEmpty || isRight True")
    public void firstTest() {
        IntStream.rangeClosed(0, 1000).forEach(i -> {
            Direction direction = generator.first();
            assertThat(direction.isEmpty() || direction.isRight()).isTrue();
        });
    }

    @Test
    @DisplayName("last()는 줄이 열려있으면 닫는다.")
    public void lastCloseTest() {
        Direction direction = generator.last(Direction.of(RIGHT));
        assertThat(direction.isLeft())
                .isTrue();
    }

    @Test
    @DisplayName("last()는 줄이 열려있지 않으면 EMPTY")
    public void lastEmptyTest() {
        Direction direction = generator.last(Direction.of(EMPTY));
        assertThat(direction.isEmpty())
                .isTrue();
    }

    @DisplayName("오른쪽으로 열었으면 다음에 왼쪽이 나와야한다.")
    @Test
    public void rightNextClosedTest() {
        IntStream.rangeClosed(0, 1000).forEach(i -> assertThat(
                generator.next(
                        Direction.of(RIGHT)
                )
        ).isEqualTo(Direction.of(LEFT)));
    }

    @DisplayName("왼쪽으로 닫았으면 무조건 EMPTY가 나와야한다.")
    @Test
    public void leftNextTest() {
        IntStream.rangeClosed(0, 1000).forEach(i -> assertThat(
                generator.next(
                        Direction.of(LEFT)
                )
        ).isEqualTo(Direction.of(EMPTY)));
    }

    @DisplayName("EMPTY의 다음에는 모두 올 수 있다.")
    @Test
    public void emptyNextTest() {
        assertThat(
            Stream.generate(() ->
                    generator.next(
                            Direction.of(EMPTY)
                    ))
                    .limit(1000)
                    .distinct()
                    .count()
        ).isEqualTo(3);
    }
}