package ladder.domain;

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
        assertThatThrownBy(() -> new Elements("tom"))
                .isInstanceOf(InvalidCountOfElementException.class)
                .hasMessage("참가자의 수는 2 이상이여야 합니다.");
    }

    @Test
    @DisplayName("총 필요한 좌표 개수는 사람의 수보다 1 작다.")
    void totalPoint() {
        assertThat(new Elements("tom", "tommy", "paul").pointCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("이름 문자열을 입력하면 구분자로 나누어 People 를 생성한다.")
    void create() {
        assertThat(new Elements("tom,tommy")).isEqualTo(new Elements("tom", "tommy"));
        assertThat(new Elements("tom,tommy")).isEqualTo(new Elements(List.of(new Element("tom", 1,0), new Element("tommy",1,1))));
    }

    @Test
    @DisplayName("이름들의 크기 중 가장 큰 크기의 값을 반환한다.")
    void maxNameSize() {
        assertThat(new Elements("tom", "tommy", "paul").maxNameSize()).isEqualTo(5);
        assertThat(new Elements("tom", "안녕하세요", "paul").maxNameSize()).isEqualTo(10);
    }

    @Test
    @DisplayName("해당하는 이름의 Element를 반환한다.")
    void searchName() {
        Element tom = new Element("tom", new Position(1, 0));
        Element paul = new Element("paul", new Position(1, 1));
        Elements elements = new Elements(List.of(tom, paul));

        assertThat(elements.value(new Name("tom"))).isEqualTo(tom);
        assertThat(elements.value(new Name("paul"))).isEqualTo(paul);
    }

    @Test
    @DisplayName("해당하는 이름의 Element가 존재하지 않을 경우 NotFoundElement를 반환한다.")
    void invalidSearchName() {
        Element tom = new Element("tom", new Position(1, 0));
        Element paul = new Element("paul", new Position(1, 1));
        Elements elements = new Elements(List.of(tom, paul));

        assertThatThrownBy(() -> elements.value(new Name("anna")))
                .isInstanceOf(NotFoundElementException.class)
                .hasMessage("anna를 찾을 수 없습니다.");
    }

    @Test
    @DisplayName("해당하는 위치값을 가진 Element를 반환한다.")
    void searchPosition() {
        Element tom = new Element("tom", new Position(1, 0));
        Element paul = new Element("paul", new Position(1, 1));
        Elements elements = new Elements(List.of(tom, paul));

        assertThat(elements.value(new Position(1,0))).isEqualTo(tom);
        assertThat(elements.value(new Position(1,1))).isEqualTo(paul);
    }
}