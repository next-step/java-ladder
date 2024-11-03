package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @Test
    void 사이즈_검증(){
        Results results = new Results(new String[]{"꽝","1000","2000","3000"});

        assertThat(results.getResults()).hasSize(4);
    }

    @Test
    void search(){
        Results results = new Results(new String[]{"꽝","1000","2000","3000"});
        Result result = results.searchIndex(3);

        assertThat(result).isEqualTo(new Result("3000"));
    }
}
