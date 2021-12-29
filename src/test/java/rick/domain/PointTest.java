package rick.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {

    @Test
    @DisplayName("양방향 이동가능 생성")
    void invalidInitValues() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Point(true, true));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "false:true:false:true:false", "false:true:true:true:false",
        "true:false:false:false:false", "true:false:true:false:true",
        "false:false:false:false:false", "false:false:true:false:true"},
        delimiter = ':')
    @DisplayName("next 생성 테스트")
    void next(boolean left, boolean right, boolean nextParameter, boolean expectedLeft, boolean expectedRight) {
        Point point = new Point(left, right);

        assertThat(point.next(nextParameter))
            .isEqualTo(new Point(expectedLeft, expectedRight));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "false:true:true:false", "false:true:true:false",
        "true:false:false:false", "true:false:false:false",
        "false:false:false:false", "false:false:false:false"},
        delimiter = ':')
    @DisplayName("last 생성 테스트")
    void last(boolean left, boolean right, boolean expectedLeft, boolean expectedRight) {
        Point point = new Point(left, right);

        assertThat(point.last())
            .isEqualTo(new Point(expectedLeft, expectedRight));
    }
}
