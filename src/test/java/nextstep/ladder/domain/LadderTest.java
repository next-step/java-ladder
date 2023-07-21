package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    @Test
    void 높이_유효성_테스트(){
        People people = new People(List.of(new Person("kbc"), new Person("kbc2")));

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Ladder(0, people));
    }
}
