package ladder.domain;

import static ladder.domain.Line.lineOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.Arrays;
import ladder.util.RandomPointStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("사다리의 첫 시작은 False 값으로 시작해야한다.")
    void firstIndexFalseTest() {
        assertDoesNotThrow(() -> new Line(Arrays.asList(false, true)));
    }

    @Test
    @DisplayName("비어있는 배열이 입력되었을 경우 익셉션을 발생시킨다.")
    void emptyTest() {
        assertAll(
                () -> assertThatThrownBy(() -> new Line(new ArrayList<>()))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("사다리 포인트 정보가 없습니다.")
        );
    }

    @Test
    @DisplayName("사다리의 첫 시작이 True일 수 없다.")
    void firstIndexTrueTest() {
        assertThatThrownBy(() -> new Line(Arrays.asList(true, false)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("첫 index 는 반드시 false 로 시작되어야합니다.")
        ;
    }

    @Test
    @DisplayName("참가자 숫자에 맞춰 하나의 사다리 라인을 생성한다.")
    void singleLineFactoryTest() {
        assertThat(lineOf(10, new RandomPointStrategy()).size())
                .isEqualTo(10);
    }


}
