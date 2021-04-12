package nextstep.ladder;

import nextstep.ladder.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {
    @Test
    @DisplayName("이름 길이 제한")
    public void nameLength(){
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new User("nameLengthOver")
                );
    }
}
