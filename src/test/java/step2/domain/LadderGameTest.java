package step2.domain;

import org.junit.jupiter.api.Test;
import step2.dto.Names;

class LadderGameTest {
    @Test
    void create() {
        final Names names = new Names("a,b,c,d" .split(","));
        final LadderGame ladderGame = new LadderGame(names.names(), 5);
        System.out.println(ladderGame);
    }
}