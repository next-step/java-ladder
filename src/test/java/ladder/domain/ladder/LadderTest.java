package ladder.domain.ladder;

import ladder.domain.creator.LadderCreator;
import ladder.domain.participant.People;
import ladder.exception.LineListNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @DisplayName("Ladder 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        List<Line> lines = new ArrayList<>();

        // when
        Ladder ladder = Ladder.from(lines);

        // then
        assertThat(ladder).isNotNull();
    }

    @DisplayName("Ladder 인스턴스 Null 주입시 예외처리 여부 테스트")
    @Test
    void 검증_NULL() {
        // given
        List<Line> lines = null;

        // when
        assertThatThrownBy(() -> Ladder.from(lines))
                .isInstanceOf(LineListNullPointerException.class)
                .hasMessage("List<Line>이 null 입니다.");
    }

    @DisplayName("Ladder 인스턴스가 LadderResultBoard 반환하는지 테스트")
    @Test
    void 반환_LadderResultBoard() {
        // given
        People people = People.of("pobi,honux,crong,jk".split(","));
        LadderHeight height = LadderHeight.valueOf(5);
        LadderResults ladderResults = LadderResults.of("꽝,꽝,5000,3000".split(","));
        LadderCreationInformation creationInformation = LadderCreationInformation.from(people, height);
        LadderCreator ladderCreator = LadderCreator.getInstance();

        // when
        Ladder ladder = ladderCreator.create(creationInformation, () -> true);
        LadderResultBoard resultBoard = ladder.run(people, ladderResults);

        // then
        assertThat(resultBoard).isNotNull();
    }
}