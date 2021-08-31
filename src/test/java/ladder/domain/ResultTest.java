package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

class ResultTest {

    private User user;
    private WinningItem item;

    @BeforeEach
    void setUp() {
        user = new User("hi");
        item = new WinningItem("item");
    }

    @Test
    @DisplayName("Result 생성 테스트")
    void createResult() {
        Result result = new Result(user, item);
        assertAll(
                () -> result.getUser().equals(user),
                () -> result.getWinningItem().equals(item)
        );
    }
}