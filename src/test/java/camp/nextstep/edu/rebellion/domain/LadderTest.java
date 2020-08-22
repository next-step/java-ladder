package camp.nextstep.edu.rebellion.domain;

import camp.nextstep.edu.rebellion.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    private static final int FIRST_ROW = 0;
    private static final int SECOND_ROW = 1;
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;

    private Ladder ladder;

    @BeforeEach
    public void setup() {
        // given
        int sizeOfRows = 3;
        int sizeOfPoints = 3;
        ladder = new Ladder(sizeOfRows, sizeOfPoints);
    }

    @DisplayName("입력한 좌표에 가로 선이 잘 생성되는지 확인")
    @Test
    public void drawLineTest() {
        // when
        ladder.drawLine(FIRST_ROW, FIRST_POINT);

        // then
        Row row = ladder.getRows().get(FIRST_ROW);
        assertThat(row.hasHorizonLine(FIRST_POINT)).isTrue();
    }

    @DisplayName("선과 인접한 좌표인 경우 선이 생성되지 않는지 확인")
    @Test
    public void alreadyDrawLineTest() {
        // given
        ladder.drawLine(FIRST_ROW, FIRST_POINT);

        // when
        ladder.drawLine(FIRST_ROW, SECOND_POINT);

        // then
        Row row = ladder.getRows().get(FIRST_ROW);
        assertThat(row.hasHorizonLine(SECOND_POINT)).isFalse();
    }

    @DisplayName("이전 행에 선이 생성 되어 있는 경우 현재 행에서 선이 생성되지 않는지 확인")
    @Test
    public void alreadyDrawLineInPreviewRowTest() {
        // given
        ladder.drawLine(FIRST_ROW, FIRST_POINT);

        // when
        ladder.drawLine(SECOND_ROW, FIRST_POINT);
        ladder.drawLine(SECOND_ROW, SECOND_POINT);

        // then
        Row row = ladder.getRows().get(SECOND_ROW);
        assertThat(row.hasHorizonLine(FIRST_POINT)).isFalse();
        assertThat(row.hasHorizonLine(SECOND_POINT)).isTrue();
    }

    @DisplayName("사다리 타기 최종 위치가 잘 반환 되는지 확인 (선이 하나도 없을 때)")
    @Test
    public void getFinalPositionEmptyLineTest() {
         /*
        아래와 같은 사다리가 생성 됨
        A     B     C
        |     |     |
        |     |     |
        |     |     |
         */
        // given
        int startingA = 0;
        int startingB = 1;
        int startingC = 2;

        // when & then
        assertAll(
                () -> assertThat(ladder.getFinalPosition(startingA)).isEqualTo(0),
                () -> assertThat(ladder.getFinalPosition(startingB)).isEqualTo(1),
                () -> assertThat(ladder.getFinalPosition(startingC)).isEqualTo(2)
        );
    }

    @DisplayName("사다리 타기 최종 위치가 잘 반환 되는지 확인 (선이 있을 때)")
    @Test
    public void getFinalPositionTest() {
        // given
        int startingA = 0;
        int startingB = 1;
        int startingC = 2;

        ladder.drawLine(0,0);
        ladder.drawLine(1,1);
        ladder.drawLine(2,0);
        /*
        아래와 같은 사다리가 생성 됨
        A     B     C
        |-----|     |
        |     |-----|
        |-----|     |
        0     1     2
        */

        // when & then
        assertAll(
                () -> assertThat(ladder.getFinalPosition(startingA)).isEqualTo(2),
                () -> assertThat(ladder.getFinalPosition(startingB)).isEqualTo(1),
                () -> assertThat(ladder.getFinalPosition(startingC)).isEqualTo(0)
        );
    }
}
