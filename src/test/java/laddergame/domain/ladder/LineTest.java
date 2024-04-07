package laddergame.domain.ladder;

import laddergame.domain.ladder.strategy.LinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static laddergame.domain.ladder.Link.LINKED;
import static laddergame.domain.ladder.Link.UNLINKED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class LineTest {
    @Nested
    @DisplayName("Line 인스턴스 생성 테스트")
    class InstanceCreationTest {
        @Nested
        @DisplayName("Line 인스턴스 생성 실패 케이스 테스트")
        class FailCaseTest {
            @Test
            @DisplayName("links가 null 또는 비어있는 경우 IllegalArgumentException이 발생한다.")
            void testNullOrEmptyCase() {
                assertThatThrownBy(() -> new Line(null))
                        .isExactlyInstanceOf(IllegalArgumentException.class);

                assertThatThrownBy(() -> new Line(Collections.emptyList()))
                        .isExactlyInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("links가 LINKED를 연속적으로 가지고 있는 경우 IllegalArgumentException이 발생한다.")
            void testOverlapLinked() {
                assertThatThrownBy(() -> new Line(List.of(LINKED, LINKED, UNLINKED, LINKED)))
                        .isExactlyInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("Line 인스턴스 생성 성공 케이스 테스트")
        class SuccessCaseTest {
            int numberOfLink = 4;
            LinkStrategy linkStrategyStub = () -> true;

            @Test
            @DisplayName("생성된 Line 인스턴스에서 links의 크기는 numberOfLink와 동일하다.")
            void testNumberOfPoints() {
                Line line = Line.newLine(numberOfLink, linkStrategyStub);
                assertThat(line.links().size()).isEqualTo(numberOfLink);
            }

            @Test
            @DisplayName("생성된 Line 인스턴스에서 links는 LINKED를 연속으로 가질 수 없다.")
            void testNonOverlap() {
                List<Link> links = Line.newLine(numberOfLink, linkStrategyStub)
                        .links();

                IntStream.range(1, numberOfLink)
                        .forEach(i -> {
                            Link now = links.get(i);
                            Link before = links.get(i - 1);
                            assumingThat(now.isLinked(), () -> assertThat(before).isEqualTo(UNLINKED));
                        });
            }
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:-1", "0:1", "1:0", "2:2"}, delimiter = ':')
    @DisplayName("nextIndexOfColumn(): 사다리 column의 왼쪽이 LINKED인 경우 indexOfColumn - 1, 오른쪽이 LINKED인 경우 indexOfColumn + 1를 반환한다. 만약 둘 다 아니면 indexOfColumn을 반환한다.")
    void testIndexOfColumn(int indexOfColumn, int expected) {
        Line line = new Line(List.of(LINKED, UNLINKED));
        assertThat(line.nextIndexOfColumn(indexOfColumn)).isEqualTo(expected);
    }
}
