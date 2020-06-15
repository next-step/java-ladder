package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicTest {

    @DisplayName("Boolean은 불변인지아닌지")
    @Test
    void booleanTest() {
        //given
        List<Boolean> booleans = new ArrayList<>();
        booleans.add(true);
        booleans.add(false);

        //when
        Boolean aBoolean = booleans.get(0);
        aBoolean = false;

        //then
        assertThat(booleans.get(0)).isEqualTo(true);
    }
}