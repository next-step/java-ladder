package laddergame.domain.ladder;

import laddergame.domain.ladder.strategy.LinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static laddergame.domain.ladder.Link.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @Nested
    @DisplayName("Line 인스턴스 생성 테스트")
    class InstanceCreationTest {
        @Nested
        @DisplayName("Line 인스턴스 생성 실패 케이스 테스트")
        class FailCaseTest {
            @Test
            @DisplayName("links가 null 또는 비어있는 경우 또는 links.size()가 짝수가 아닌 경우 IllegalArgumentException이 발생한다.")
            void testNullOrEmptyCase() {
                assertThatThrownBy(() -> new Line(null))
                        .isExactlyInstanceOf(IllegalArgumentException.class);

                assertThatThrownBy(() -> new Line(Collections.emptyList()))
                        .isExactlyInstanceOf(IllegalArgumentException.class);

                assertThatThrownBy(() -> new Line(List.of(DOWN)))
                        .isExactlyInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("Linked(RIGHT, LEFT) 또는 UnLinked(DOWN, DOWN) 단위로 links에 배치되어 있어야한다. 그렇지 않으면 IllegalArgumentException이 발생한다.")
            void testInvalidLinkedUnLinkedCase() {
                assertThatThrownBy(() -> new Line(List.of(LEFT, RIGHT)))
                        .isExactlyInstanceOf(IllegalArgumentException.class);

                assertThatThrownBy(() -> new Line(List.of(RIGHT, DOWN, LEFT, DOWN)))
                        .isExactlyInstanceOf(IllegalArgumentException.class);

                assertThatThrownBy(() -> new Line(List.of(DOWN, RIGHT, DOWN, LEFT)))
                        .isExactlyInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("LINKED(RIGHT, LEFT)가 연속되면 IllegalArgumentException이 발생한다.")
            void testOverlapLinkedCase() {
                assertThatThrownBy(() -> new Line(List.of(RIGHT, LEFT, RIGHT, LEFT)))
                        .isExactlyInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("Line 인스턴스 생성 성공 케이스 테스트")
        class SuccessCaseTest {
            int numberOfLinkedUnLinked = 4;
            LinkStrategy linkStrategyStub = () -> true;

            @Test
            @DisplayName("생성된 Line 인스턴스에서 links의 크기는 numberOfLinkedUnLinked * 2와 동일하다.")
            void testNumberOfPoints() {
                Line line = Line.newLine(numberOfLinkedUnLinked, linkStrategyStub);
                assertThat(line.links().size()).isEqualTo(numberOfLinkedUnLinked * 2);
            }
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:-1", "0:1", "1:0", "2:2"}, delimiter = ':')
    @DisplayName("nextIndexOfColumn(): 사다리 column의 왼쪽이 LINKED인 경우 indexOfColumn - 1, 오른쪽이 LINKED인 경우 indexOfColumn + 1를 반환한다. 만약 둘 다 아니면 indexOfColumn을 반환한다.")
    void testNextIndexOfColumn(int indexOfColumn, int expected) {
        Line line = new Line(List.of(RIGHT, LEFT, DOWN, DOWN));
        assertThat(line.nextIndexOfColumn(indexOfColumn)).isEqualTo(expected);
    }
}
