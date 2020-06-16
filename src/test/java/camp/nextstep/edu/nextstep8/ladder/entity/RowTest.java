package camp.nextstep.edu.nextstep8.ladder.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RowTest {
    private static int MAX_COLS = 5;

    Row row;

    @BeforeEach
    public void generateOneRows() {
        row = new Row(0, MAX_COLS);
    }

    @DisplayName("Row 에서 좌표에 맞는 Point가 잘 선택되는 지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "0:0:true",
            "0:1:true",
            "0:4:true",
            "0:5:false",
            "1:0:false"
    }, delimiter = ':')
    public void pickTest(int x, int y, boolean expected) {
        // when
        Point point = row.pick(x, y);
        assertThat(isExists(point)).isEqualTo(expected);
    }

    @DisplayName("Row에서 좌표를 입력했을 때 선이 잘 그려지는지 확인")
    @Test
    public void drawTest() {
        // given
        int curX = 0;
        int curY = 0;

        // when
        row.draw(curX, curY);

        // then
        Point cur = row.pick(curX, curY);
        Point next = row.pick(curX, curY + 1);

        assertAll(
                () -> assertThat(cur.isStart()).isTrue(),
                () -> assertThat(next.isEnd()).isTrue()
        );
    }

    @DisplayName("이미 선지 존재 할 경우 선이 그려지지 않는지 확인")
    @Test
    public void alreadyDrawTest() {
        // given
        int curX = 0;
        int curY = 0;

        // draw (0, 0) -> (0, 1)
        row.draw(curX, curY);

        // when draw (0, 1) -> (0, 2)
        row.draw(curX, curY + 1);

        // then
        Point cur = row.pick(curX, curY + 1);
        Point next = row.pick(curX, curY + 2);

        assertAll(
                () -> assertThat(cur.isStart()).isFalse(),
                () -> assertThat(next.isEnd()).isFalse()
        );
    }

    @DisplayName("마지막 컬럼일 경우 선이 그려지지 않는지 확인")
    @Test
    public void meetLastTest() {
        // given
        int curX = 0;
        int curY = MAX_COLS - 1;

        // when
        row.draw(curX, curY);

        // then
        Point cur = row.pick(curX, curY);

        assertThat(cur.isStart()).isFalse();
    }

    private boolean isExists(Point point) {
        return point != null;
    }
}

