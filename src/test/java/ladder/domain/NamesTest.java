package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class NamesTest {

    @Test
    @DisplayName("이름개수 확인")
    public void nameSize() {
        Names names = new Names(Arrays.asList("aaa", "bbb", "ccc"));
        assertThat(names.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("최소인원 확인")
    public void checkNamesMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Names(Arrays.asList("aaa"));

            fail("참가자 인원수 에러발생해야 한다.");
        });
    }


}
