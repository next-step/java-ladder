package nextstep.ladder;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @Test
    void personCreateFailureTest(){
        assertThatThrownBy(() -> new Person("tomson"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
