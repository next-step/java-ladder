package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import nextstep.ladder.dto.LadderResult;
import org.junit.jupiter.api.Test;

public class LadderParticipationResultTest {

    @Test
    void 이름과_결과는_같은_크기여야한다() {
        assertThatCode(() -> new LadderParticipationResult(new Names(List.of("test1", "test2", "test3", "test4")),
                new LadderResult(List.of("2000", "1000", "꽝", "1000")))).doesNotThrowAnyException();
    }

    @Test
    void 이름과_결과의_크기가_같지않으면_예외를_발생한다() {
        assertAll(() -> {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new LadderParticipationResult(new Names(List.of("test1", "test2", "test3", "test4")),
                            new LadderResult(List.of("2000", "1000", "꽝", "1000", "2000"))));
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new LadderParticipationResult(new Names(List.of("test1", "test2", "test3", "test4", "test5")),
                            new LadderResult(List.of("2000", "1000", "꽝", "1000"))));
        });
    }
}
