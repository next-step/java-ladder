package ladder.domain;

import ladder.strategy.LineGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderCreateModuleTest {

    @DisplayName("LadderCreateModule 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        LadderCreateModule ladderCreateModule = LadderCreateModule.getInstance();

        // then
        assertThat(ladderCreateModule).isNotNull();
    }

    @DisplayName("LadderCreateModule 인스턴스가 사다리를 생성하는지 테스트")
    @Test
    void 반환_사다리() {
        // given
        People people = People.of("a,b,c".split(","));
        LadderHeight ladderHeight = LadderHeight.valueOf(5);
        LadderCreationInformation creationInformation = LadderCreationInformation.from(people, ladderHeight);
        LineGenerateStrategy strategy = () -> true;

        // when
        LadderCreateModule ladderCreateModule = LadderCreateModule.getInstance();
        Ladder ladder = ladderCreateModule.create(creationInformation, strategy);


        // then
        assertThat(ladder).isNotNull();
    }

}