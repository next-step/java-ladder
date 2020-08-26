package ladder.domain.element;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderElementTest {

    @Test
    @DisplayName("사람 이름 blank 설정")
    void testSetNameBlank() {
        assertThatThrownBy(() -> new LadderElement("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LadderElement(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LadderElement(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 기준 길이 이상 설정")
    void testSetNameOverLength() {
        assertThatThrownBy(() -> new LadderElement("mondss")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사람 정상 생성")
    void testCreateElement() {
        final String name = "monds";
        LadderElement element = new LadderElement(name);
        assertThat(element.getName()).isEqualTo(name);
    }
}
