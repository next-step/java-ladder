package ladder.backEnd.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("높이 숫자만큼 Line 생성")
    void create() {
        List<String> names = List.of("jio", "bora", "hey", "star");
        Ladder ladder = new Ladder();
        Lines lines = ladder.create(names, 5);
        assertThat(lines.getValues().size()).isEqualTo(5);
    }
}
