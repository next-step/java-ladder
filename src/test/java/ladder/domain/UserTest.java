package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("pobi");
    }

    @DisplayName("5글자 초과한 이름에 대해 에러 발생")
    @Test
    public void createUserWithError() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> user = new User("pobierror"));
    }

    @DisplayName("공백, null에 대해 에러 발생")
    @ParameterizedTest
    @NullAndEmptySource
    public void createUserWithEmptyNull(String inputText) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> user = new User(inputText));
    }

    @Test
    public void printUser(){
        user = new User("po");
        System.out.println(user);
    }
}
