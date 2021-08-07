package ladder.domain.line;

import ladder.domain.point.Direction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ladder.domain.point.Direction.*;
import static org.assertj.core.api.Assertions.*;

public class RandomDirectionCreateStrategyTest {
    private static DirectionCreateStrategy directionCreateStrategy;

    @BeforeAll
    public static void setUp() {
        directionCreateStrategy = new RandomDirectionCreateStrategy();
    }

    @ValueSource(ints = {
            2, 10, 13, 103
    })
    @DisplayName("pointSize의 크기가 2 이상이라면 어떠한 경우에도 정상적으로 생성 되어야 함")
    @ParameterizedTest
    void buildTest(int pointSize) {
        assertThatCode(() ->
                LadderLine.builder()
                        .auto(directionCreateStrategy)
                        .pointSize(pointSize)
                        .build()
        ).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("first()는 isEmpty || isRight True")
    void firstTest() {
        IntStream.rangeClosed(0, 1000).forEach(i -> {
            Direction direction = directionCreateStrategy.first();
            assertThat(direction.isEmpty() || direction.isRight()).isTrue();
        });
    }

    @Test
    @DisplayName("last()는 줄이 열려있으면 닫는다.")
    void lastCloseTest() {
        Direction direction = directionCreateStrategy.last(RIGHT);
        assertThat(direction.isLeft())
                .isTrue();
    }

    @Test
    @DisplayName("last()는 줄이 열려있지 않으면 EMPTY")
    void lastEmptyTest() {
        Direction direction = directionCreateStrategy.last(EMPTY);
        assertThat(direction.isEmpty())
                .isTrue();
    }

    @DisplayName("오른쪽으로 열었으면 다음에 왼쪽이 나와야한다.")
    @Test
    void rightNextClosedTest() {
        IntStream.rangeClosed(0, 1000).forEach(i -> assertThat(
                directionCreateStrategy.next(
                        RIGHT
                )
        ).isEqualTo(LEFT));
    }

    @DisplayName("왼쪽으로 닫았으면 RIGHT와 EMPTY가 올 수 있다.")
    @Test
    void leftNextTest() {
        assertThat(
                Stream.generate(() ->
                        directionCreateStrategy.next(
                                LEFT
                        ))
                        .limit(1000)
                        .distinct()
                        .collect(Collectors.toList())
        ).containsOnly(
                RIGHT, EMPTY
        );
    }

    @DisplayName("EMPTY의 다음에는 RIGHT와 EMPTY가 올 수 있다.")
    @Test
    void emptyNextTest() {
        assertThat(
            Stream.generate(() ->
                    directionCreateStrategy.next(
                            EMPTY
                    ))
                    .limit(1000)
                    .distinct()
                    .collect(Collectors.toList())
        ).containsOnly(
                RIGHT, EMPTY
        );
    }
}