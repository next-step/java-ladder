package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.dto.CommaSeparatedResult;
import org.junit.jupiter.api.Test;

public class CommaSeparatedResultTest {

    @Test
    public void 분리된이름을_생성한다() {
        CommaSeparatedResult commaSeparatedResult = new CommaSeparatedResult("test1,test2");
        assertThat(commaSeparatedResult).isEqualTo(new CommaSeparatedResult("test1,test2"));
    }
}
