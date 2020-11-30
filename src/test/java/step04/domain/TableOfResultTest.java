package step04.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TableOfResultTest {
    TableOfResult tableOfResult;

    @BeforeEach
    void setup() {
        tableOfResult = TableOfResult.of(Arrays.asList(0, 1, 2, 3));
    }

    @DisplayName("생성자")
    @Test
    void test_constructor_of() {
        assertThat(tableOfResult)
                .isEqualTo(TableOfResult.of(Arrays.asList(0, 1, 2, 3)));
    }


    @DisplayName("swap index")
    @Test
    void test_swapIndex() {
        assertThat(tableOfResult.swapIndex(2))
                .isEqualTo(TableOfResult.of(Arrays.asList(0, 1, 3, 2)));
    }

    @DisplayName("사다리 match table ")
    @Test
    void test_matchTable() {
        Ladder ladder = Ladder.of(3, 4, () -> true);
        TableOfResult expectTable = TableOfResult.of(Arrays.asList(1, 0, 3, 2));
        assertThat(ladder.matchTable()).isEqualTo(expectTable);
    }

    @DisplayName("size")
    @Test
    void test_size() {
        assertThat(tableOfResult.size()).isEqualTo(4);
    }

    @DisplayName("indexOf")
    @Test
    void test_indexOf() {
        assertThat(tableOfResult.indexOf(3))
                .isEqualTo(3);
    }
}
