package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultMapTest {
    @Test
    void createTest() {
        assertThat(ResultMap.create()).isInstanceOf(ResultMap.class);
    }
}
