package nextstep.ladder;

import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    void create(){
        String test = String.format("%5s", "foo").replace(' ', '*');
        System.out.println(test);
    }
}
