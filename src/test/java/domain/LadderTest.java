package domain;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {

    @Test
    public void 사람이름은_5글자를_넘으면_안된다() {
        String IllegalName = "abcdef";

        assertThrows(IllegalArgumentException.class, () -> Players.of(new String[] {IllegalName}));
    }

    @Test
    public void 플레이어_이름을_입력하여_만든다() {
        Players players = Players.of(new String[]{"abc", "aaaa", "bcdef"});

        assertEquals(players.countOfPlayers(), 3);
    }
}