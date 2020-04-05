package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Users users;

    @BeforeEach
    void setUp() {
        users = Users.of("Yohan,Hyemi,Hyeji");
    }

    @DisplayName("Users와 Height 입력 시 유저 수 만큼의 Link를 가진 Line을 Height 만큼 만든다 ")
    @Test
    void create() {
        Ladder ladder = Ladder.of(users, Height.of(5));

        assertThat(ladder.getLadderLines().size()).isEqualTo(5);
        ladder.getLadderLines()
                .forEach(line -> assertThat(line.getLinkCount()).isEqualTo(users.getUserCount()));
    }
}
