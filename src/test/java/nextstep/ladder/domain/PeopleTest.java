package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PeopleTest {
    @Test
    void 참여자_길이_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> new People(List.of(new Person("kbc"))));
    }

    @Test
    void toString_테스트(){
        People people = new People(List.of(new Person("kbc"), new Person("kbc2")));

        String result = people.toString();

        assertThat(result).isEqualTo("   kbc  kbc2");
    }


}
