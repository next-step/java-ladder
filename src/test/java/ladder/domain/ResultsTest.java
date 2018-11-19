package ladder.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    @Test
    public void 생성() {
        String values = "꽝,꽝,1000";
        assertThat(Results.of(values)).isEqualTo(Results.of(values));
    }
}