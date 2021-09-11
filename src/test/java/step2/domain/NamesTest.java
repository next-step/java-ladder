package step2.domain;

import org.junit.jupiter.api.Test;
import step2.dto.Name;
import step2.dto.Names;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {
    @Test
    void createNamesFailTest() {
        String[] input = "aaa,bb,ccc,ddddd,eeeeee".split(",");
        assertThatThrownBy(() -> new Names(input))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("사람 이름은 최대 5글자 입니다.");
    }

    @Test
    void createNamesSuccessTest() {
        String[] input = "aaa,bb,ccc,ddddd,eeeee".split(",");
        final Names actual = new Names(input);
        final Names expected = new Names(Arrays.asList(new Name("aaa"),
                new Name("bb"),
                new Name("ccc"),
                new Name("ddddd"),
                new Name("eeeee")));
        assertThat(actual).isEqualTo(expected);
    }
}