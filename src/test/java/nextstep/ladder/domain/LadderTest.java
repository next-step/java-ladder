package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Collections;
import java.util.List;
import nextstep.ladder.factory.LadderFactory;
import nextstep.ladder.factory.LinesFactory;
import nextstep.ladder.interfaces.Position;
import org.junit.jupiter.api.Test;

public class LadderTest {


    @Test
    public void 입력한높이만큼_라인을_생성한다() {
        List<Boolean> booleans = List.of(true, false);

        NonConsecutiveFlagGeneratorFake fakeGenerator = createFakeGenerator(booleans);
        Ladder ladder = LadderFactory.ladder(2, 2, fakeGenerator);
        assertThat(ladder).isEqualTo(
                new Ladder(2, List.of(
                        LinesFactory.lines(booleans),
                        LinesFactory.lines(booleans))));
    }

    @Test
    public void 입력한높이만큼_라인을_생성한다2() {
        List<Boolean> booleans = List.of(true, false);

        NonConsecutiveFlagGeneratorFake fakeGenerator = createFakeGenerator(booleans);
        Ladder ladder = LadderFactory.ladder(2, 2, fakeGenerator);
        assertThat(ladder).isEqualTo(
                new Ladder(2, List.of(
                        LinesFactory.lines(booleans),
                        LinesFactory.lines(booleans))));
    }

    @Test
    public void 라인이_존재하지_않을_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Ladder(2, Collections.emptyList()));
    }

    @Test
    public void 이동_최종_결과를_반환한다() {
        List<Boolean> booleans = List.of(true, false, true);
        NonConsecutiveFlagGeneratorFake fakeGenerator = createFakeGenerator(booleans);
        Ladder ladder = LadderFactory.ladder(3, 4, fakeGenerator);

        Position result = ladder.result();

        assertThat(result).isEqualTo(new Position(List.of(1, 0, 3, 2)));
    }

    private static NonConsecutiveFlagGeneratorFake createFakeGenerator(List<Boolean> lines) {
        return new NonConsecutiveFlagGeneratorFake(lines);
    }
}
