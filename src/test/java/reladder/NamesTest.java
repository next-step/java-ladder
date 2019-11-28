package reladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reladder.domain.Names;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    @Test
    @DisplayName("이름 중복 체크")
    void checkDuplicateByName() {
        // give
        Names names = new Names("a,a,b,b,c");
        // when
        int length = names.length();
        // then
        assertThat(length).isEqualTo(3);
    }
}
