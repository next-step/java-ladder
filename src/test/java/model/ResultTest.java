package model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    public void getResults() {
        List<Result> results = Result.getResults("꽝,5000,꽝,3000");
        assertThat(results.size()).isEqualTo(4);
    }
}