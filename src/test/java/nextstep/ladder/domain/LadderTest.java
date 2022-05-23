package nextstep.ladder.domain;

import nextstep.ladder.view.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("라인 없이 사다리 생성시 예외를 던진다.")
    void exception_creation(){
        assertThatThrownBy(()->{
            new Ladder(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}