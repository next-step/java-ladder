package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class NamesTest {
    private Names names;

    @BeforeEach
    public void setup(){
        names = new Names(Arrays.asList("aaa", "bbb", "ccc"));
    }

    @Test
    @DisplayName("이름개수 확인")
    public void nameSize() {
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

    @Test
    @DisplayName("사다리 결과 이름 확인")
    public void checkName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            names.playerName("ddd");

            fail("이름 에러가 발생해야 한다.");
        });
    }

}
