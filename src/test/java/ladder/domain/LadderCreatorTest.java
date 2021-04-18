package ladder.domain;

import ladder.strategy.LineGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderCreatorTest {

    @DisplayName("LadderCreator 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        LadderCreator ladderCreator = LadderCreator.getInstance();

        // then
        assertThat(ladderCreator).isNotNull();
    }

    @DisplayName("LadderCreator 인스턴스가 사다리를 생성하는지 테스트")
    @Test
    void 반환_사다리() {
        // given
        People people = People.of("a,b,c".split(","));
        LadderHeight ladderHeight = LadderHeight.valueOf(5);
        LadderCreationInformation creationInformation = LadderCreationInformation.from(people, ladderHeight);
        LineGenerateStrategy strategy = () -> true;

        // when
        LadderCreator ladderCreator = LadderCreator.getInstance();
        Ladder ladder = ladderCreator.create(creationInformation, strategy);

        // then
        assertThat(ladder).isNotNull();
    }

}