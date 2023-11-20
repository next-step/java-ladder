package ladder.domain;

import ladder.domain.Name;
import ladder.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NamesTest {

    @Test
    @DisplayName("이름 목록은 이름들을 가질 수 있다.")
    void createNames(){
        assertThat(new Names(List.of(new Name("ryan"), new Name("jason"), new Name("brown")))).isInstanceOf(Names.class);
    }

    @Test
    @DisplayName("이름 목록은 이름이 2개 미만일 경우 예외를 발생시킨다.")
    void createNamesWithLessThanTwoNames(){
        assertThatThrownBy(() -> new Names(List.of(new Name("ryan"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최소 2개 이상이어야 합니다.");
    }
}
