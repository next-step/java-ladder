package laddergameRDD.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RowTest {
    @DisplayName("사다리 행 정상 생성")
    @Test
    void create_row() {
        Row row = new Row(
                List.of(
                        Point.first(false),
                        Point.first(false).next(true),
                        Point.first(false).next(true).end()
                )
        );
        assertThat(row.getRow()).containsExactly(false, false, true);
    }

    @DisplayName("사다리 행 생성자 테스트")
    @Test
    void create_row_with_column_count() {
        Row row = new Row(3, ()->true);
        assertThat(row.getRow()).containsExactly(false, true, false);
    }

    @DisplayName("사다리 한 행 내려가는 기능 정상 동작")
    @Test
    void down_one_row() {
        Row row = new Row(
                List.of(
                        Point.first(true),
                        Point.first(true).next(false),
                        Point.first(true).next(false).end()
                )
        );
        assertAll(
                () -> assertThat(row.moveDown(0)).isEqualTo(1),
                () -> assertThat(row.moveDown(1)).isEqualTo(0),
                () -> assertThat(row.moveDown(2)).isEqualTo(2)
        );
    }
}
