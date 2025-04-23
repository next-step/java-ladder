package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderLineTest {
    List<Point> normalPoints;
    ConnectionStrategy connectionStrategy;

    @BeforeEach
    void setUp() {
        connectionStrategy = new RandomConnectionStrategy();
    }

    @Test
    @DisplayName("생성자 동작 확인")
    void test_generate() {
        assertThat(LadderLine.generate(3, connectionStrategy)).isInstanceOf(LadderLine.class);
    }

    @Test
    @DisplayName("생성자 동작 확인 - Edge Point 검증")
    void test_edge_point() {
        LadderLine ladderLine = LadderLine.generate(3, new RandomConnectionStrategy());
        Point first = ladderLine.asList().get(0);
        Point last = ladderLine.asList().get(ladderLine.asList().size() - 1);
        assertThat(first.isValidFirst()).isTrue();
        assertThat(last.isValidLast()).isTrue();
    }

    @Test
    @DisplayName("생성자 동작 확인 - Pair Point 검증")
    void test_pair_point() {
        LadderLine ladderLine = LadderLine.generate(3, new RandomConnectionStrategy());
        for (int i = 0; i < ladderLine.asList().size() - 1; i++) {
            Point current = ladderLine.asList().get(i);
            Point next = ladderLine.asList().get(i + 1);
            assertThat(current.isMatchWithNext(next)).isTrue();
        }
    }

    @Test
    @DisplayName("LadderLine.generate로 생성된 LadderLine 사이즈 확인")
    void test_ladder_line_size() {
        LadderLine ladderLine = LadderLine.generate(3, connectionStrategy);
        assertThat(ladderLine.asList()).isNotEmpty();
        assertThat(ladderLine.asList()).hasSize(3);
    }
}
