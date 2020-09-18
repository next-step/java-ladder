package step2.domain;

import org.assertj.core.internal.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {

    @Test
    @DisplayName("라인 생성시 게임 참여자가 1명 미만일때")
    public void createLine() {
        assertThrows(IllegalArgumentException.class, () -> Line.create(-1));
    }
}


