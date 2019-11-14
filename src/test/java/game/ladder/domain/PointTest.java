package game.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2019/11/11.
 */
class PointTest {

    @DisplayName("Point 생성")
    @ParameterizedTest
    @CsvSource(value = {"false:false", "true:true"}, delimiter = ':')
    void of(boolean input, boolean expected) {

        // when
        Point point = Point.of(input);

        // then
        assertThat(point).isNotNull();
    }

    @DisplayName("Point movable")
    @ParameterizedTest
    @CsvSource(value = {"false:false", "true:true"}, delimiter = ':')
    void movable(boolean input, boolean expected) {

        // when
        Point point = Point.of(input);

        // then
        assertThat(point.isLinkable()).isEqualTo(expected);
    }

    @DisplayName("움직일 수 없는 점 다음은 움직일 수 있는 점")
    @Test
    void createNextPointFromImmovable() {

        // given
        Point prevPoint = Point.of(false);

        // when
        Point point = prevPoint.createNextPoint(() -> true);

        // then
        assertThat(point.isLinkable()).isEqualTo(true);
    }

    @DisplayName("움직이는 점 다음은 움질일 수 없는 점")
    @Test
    void createNextPointFromMovable() {

        // given
        Point prevPoint = Point.of(true);

        // when
        Point point = prevPoint.createNextPoint(() -> true);

        // then
        assertThat(point.isLinkable()).isEqualTo(false);
    }
}