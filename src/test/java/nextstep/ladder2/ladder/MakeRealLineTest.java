package nextstep.ladder2.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MakeRealLineTest {
    @Test
    void test(){
        MakeRealLine real = new MakeRealLine();
        //assertThat(real.makeLine(5)).doesNotContainSequence(true,true,true,true,true);
        assertThat(real.makeLine(true)).isFalse();
    }
}