package ladder.domain;

import ladder.constant.Type;
import ladder.exception.InvalidCountOfElementException;
import ladder.exception.NotFoundElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ElementsTest {

    @Test
    @DisplayName("참가자 수는 2 이상이여야 한다.")
    void invalidCount() {
        assertThatThrownBy(() -> Elements.createPlayers("tom"))
                .isInstanceOf(InvalidCountOfElementException.class)
                .hasMessage("참가자의 수는 2 이상이여야 합니다.");
    }

    @Test
    @DisplayName("총 필요한 좌표 개수는 사람의 수보다 1 작다.")
    void totalPoint() {
        assertThat(Elements.createPlayers("tom, tommy, paul").pointCount()).isEqualTo(2);
        assertThat(Elements.createResults("tom, tommy, paul").pointCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("이름들의 크기 중 가장 큰 크기의 값을 반환한다.")
    void maxNameSize() {
        assertThat(Elements.createPlayers("tom, tommy, paul").maxNameSize()).isEqualTo(5);
        assertThat(Elements.createResults("tom, tommy, paul").maxNameSize()).isEqualTo(5);
        assertThat(Elements.createPlayers("tom, 안녕하세요, paul").maxNameSize()).isEqualTo(10);
        assertThat(Elements.createResults("tom, 안녕하세요, paul").maxNameSize()).isEqualTo(10);
    }

    @Test
    @DisplayName("Type.FIXED Position 을 가지고 있는 Elements 중 해당하는 이름의 Element 를 반환한다.")
    void searchName() {
        Element tom = new Element("tom", PositionTest.FIXED_VALUE_ZERO);
        Element paul = new Element("paul", PositionTest.FIXED_VALUE_ONE);
        Elements elements = new Elements(List.of(tom, paul));

        assertThat(elements.value(new Name("tom"))).isEqualTo(tom);
        assertThat(elements.value(new Name("paul"))).isEqualTo(paul);
    }

    @Test
    @DisplayName("해당하는 이름의 Element가 존재하지 않을 경우 NotFoundElement를 반환한다.")
    void invalidSearchName() {
        Element tom = new Element("tom", PositionTest.FIXED_VALUE_ZERO);
        Element paul = new Element("paul", PositionTest.FIXED_VALUE_ONE);
        Elements elements = new Elements(List.of(tom, paul));

        assertThatThrownBy(() -> elements.value(new Name("anna")))
                .isInstanceOf(NotFoundElementException.class)
                .hasMessage("anna를 찾을 수 없습니다.");
    }

    @Test
    @DisplayName("해당하는 위치값을 가진 Element를 반환한다.")
    void searchPosition() {
        Element tom = new Element("tom", PositionTest.FIXED_VALUE_ZERO);
        Element paul = new Element("paul", PositionTest.FIXED_VALUE_ONE);
        Elements elements = new Elements(List.of(tom, paul));

        assertThat(elements.value(new Position(1,0, Type.FIXED))).isEqualTo(tom);
        assertThat(elements.value(new Position(1,1, Type.FIXED))).isEqualTo(paul);
    }
}