package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.exception.NotExistNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {

    private final String name1 = "12345";
    private final String name2 = "123";
    private Names names = new Names(Arrays.asList(name1, name2));

    @Test
    void createTest() {
        Names names = new Names(List.of(name1, name2));

        assertThat(names).isNotNull();
    }

    @DisplayName("목록에 있는 이름의 인덱스를 찾는다.")
    @Test
    void indexOfTest1() {
        int index = this.names.indexOf(name1);
        assertThat(index).isEqualTo(0);
        index = this.names.indexOf(name2);
        assertThat(index).isEqualTo(1);
    }

    @DisplayName("목록에 없는 이름의 인덱스를 찾으면 예외가 발생한다.")
    @Test
    void indexOfTest2() {
        assertThatThrownBy(() -> this.names.indexOf("1234"))
            .isInstanceOf(NotExistNameException.class);
    }

}