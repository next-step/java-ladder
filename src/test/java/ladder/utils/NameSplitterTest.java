package ladder.utils;

import ladder.domain.player.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NameSplitterTest {

    @DisplayName("콤마를 구분자로 이름 리스트를 반환")
    @Test
    void split() {
        List<Name> names = NameSplitter.split("1,2");

        assertThat(names).isEqualTo(Arrays.asList(Name.valueOf("1"), Name.valueOf("2")));
    }
}
