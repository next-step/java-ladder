package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {
    @DisplayName("value 가 같으면 동등성 비교가 참을 리턴한다")
    @Test
    public void equals() {
        //given
        Line line11 = new Line(1, 1);
        Line line22 = new Line(2, 2);
        Line line21 = new Line(2, 2);
        //when
        //then
        assertAll("동등성을 검증한다",
                () -> assertThat(line22).as("").isEqualTo(line21),
                () -> assertThat(line11).as("").isNotEqualTo(line22)
        );
    }

    @DisplayName("동일한 column, row 를 갖는 Line 이면 인스턴스가 다르더라도 동일한 객체로 취급하는 로직을 검증")
    @Test
    public void isSame() {
        //given
        Line comparativeLine11 = new Line(1, 1);
        //when
        //then
        assertAll("동등성을 검증한다",
                () -> assertThat(comparativeLine11.isSame(1, 1)).as("").isTrue(),
                () -> assertThat(comparativeLine11.isSame(2, 1)).as("").isFalse(),
                () -> assertThat(comparativeLine11.isSame(1, 2)).as("").isFalse(),
                () -> assertThat(comparativeLine11.isSame(2, 2)).as("").isFalse()
        );
    }
}