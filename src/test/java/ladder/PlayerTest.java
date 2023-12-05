package ladder;

import ladder.domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    @Test
    public void 유저생성_실패테스트(){
        assertThatThrownBy(() -> {
            new Player("abcdef");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 유저생성_성공테스트(){
        assertThatThrownBy(() -> {
            new Player("abcde");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
