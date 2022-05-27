package ladder.domain;

import ladder.exception.InvalidCountOfElementException;
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
}