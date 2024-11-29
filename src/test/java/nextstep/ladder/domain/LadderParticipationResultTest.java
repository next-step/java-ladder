package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import nextstep.ladder.dto.CommaSeparatedResult;
import nextstep.ladder.dto.ResultDto;
import nextstep.ladder.interfaces.Position;
import org.junit.jupiter.api.Test;

public class LadderParticipationResultTest {

    @Test
    void 이름과_결과는_같은_크기여야한다() {
        assertThatCode(() -> new LadderParticipationResult(
                new CommaSeparatedResult("test1,test2,test3,test4"),
                new CommaSeparatedResult("2000,1000,꽝,1000"))).doesNotThrowAnyException();
    }

    @Test
    void 이름과_결과의_크기가_같지않으면_예외를_발생한다() {
        assertAll(() -> {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new LadderParticipationResult(
                            new CommaSeparatedResult("test1,test2,test3,test4"),
                            new CommaSeparatedResult("2000,1000,꽝,1000,2000")));
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new LadderParticipationResult(
                            new CommaSeparatedResult("test1,test2,test3,test4,test5"),
                            new CommaSeparatedResult("2000,1000,꽝,1000")));
        });
    }

    @Test
    void 최종결과를_매핑해서_반환한다() {
        CommaSeparatedResult commaSeparatedResult = new CommaSeparatedResult("test1,test2,test3,test4");
        CommaSeparatedResult ladderResult = new CommaSeparatedResult("2000,1000,꽝,1000");
        LadderParticipationResult ladderParticipationResult = new LadderParticipationResult(commaSeparatedResult,
                ladderResult);

        ResultDto resultDto = ladderParticipationResult.match(new Position(List.of(2, 3, 1, 0)));
        Map<String, String> result = Map.of("test1", "꽝", "test2", "1000", "test3", "1000", "test4", "2000");
        assertThat(resultDto).isEqualTo(new ResultDto(result));
    }
}
