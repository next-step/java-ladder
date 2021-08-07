package ladder.domain.point;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ladder.domain.point.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UnconnectedRandomDirectionCreateStrategyTest {
    private static DirectionCreateStrategy generator;

    @BeforeAll
    public static void setUp() {
        generator = new RandomDirectionCreateStrategy();
    }

    @Test
    @DisplayName("first()는 isEmpty || isRight True")
    void firstTest() {
        IntStream.rangeClosed(0, 1000).forEach(i -> {
            Direction direction = generator.first();
            assertThat(direction.isEmpty() || direction.isRight()).isTrue();
        });
    }

    @Test
    @DisplayName("last()는 줄이 열려있으면 닫는다.")
    void lastCloseTest() {
        Direction direction = generator.last(RIGHT);
        assertThat(direction.isLeft())
                .isTrue();
    }

    @Test
    @DisplayName("last()는 줄이 열려있지 않으면 EMPTY")
    void lastEmptyTest() {
        Direction direction = generator.last(EMPTY);
        assertThat(direction.isEmpty())
                .isTrue();
    }

    @DisplayName("오른쪽으로 열었으면 다음에 왼쪽이 나와야한다.")
    @Test
    void rightNextClosedTest() {
        IntStream.rangeClosed(0, 1000).forEach(i -> assertThat(
                generator.next(
                        RIGHT
                )
        ).isEqualTo(LEFT));
    }

    @DisplayName("왼쪽으로 닫았으면 무조건 EMPTY가 나와야한다.")
    @Test
    void leftNextTest() {
        IntStream.rangeClosed(0, 1000).forEach(i -> assertThat(
                generator.next(
                        LEFT
                )
        ).isEqualTo(EMPTY));
    }

    @DisplayName("EMPTY의 다음에는 모두 올 수 있다.")
    @Test
    void emptyNextTest() {
        assertThat(
            Stream.generate(() ->
                    generator.next(
                            EMPTY
                    ))
                    .limit(1000)
                    .distinct()
                    .count()
        ).isEqualTo(3);
    }
}