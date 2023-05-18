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
        Line lineOne = new Line(1, 1);
        Line lineTwo = new Line(2, 2);
        Line lineTwice = new Line(2, 2);
        //when
        //then
        assertAll("동등성을 검증한다",
                () -> assertThat(lineTwo).as("").isEqualTo(lineTwice),
                () -> assertThat(lineOne).as("").isNotEqualTo(lineTwo)
        );
    }

    @DisplayName("")
    @Test
    public void isSame() {
        //given
        Line lineOne = new Line(1, 1);
        //when
        //then
        assertAll("동등성을 검증한다",
                () -> assertThat(lineOne.isSame(1, 1)).as("").isTrue(),
                () -> assertThat(lineOne.isSame(2, 1)).as("").isFalse(),
                () -> assertThat(lineOne.isSame(1, 2)).as("").isFalse(),
                () -> assertThat(lineOne.isSame(2, 2)).as("").isFalse()
        );
    }
}