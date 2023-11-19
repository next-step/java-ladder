package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    @Test
    @DisplayName("이름 목록은 이름들을 가질 수 있다.")
    void createNames(){
        assertThat(new Names(List.of(new Name("ryan"), new Name("jason"), new Name("brown")))).isInstanceOf(Names.class);
    }

}
