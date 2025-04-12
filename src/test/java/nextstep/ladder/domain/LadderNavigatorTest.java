package nextstep.ladder.domain;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderNavigatorTest {

    @Test
    void 사다리_결과() {
        List<String> names = List.of("이름1", "이름2", "이름3");
        List<String> results = List.of("결과1", "이름2", "이름3");
        int height = 5;

        List<Leg> legs = Leg.createLegs(names, results, height);
        Ladder ladder = new Ladder(legs);

        RandomRungStrategy randomRungStrategy = new RandomRungStrategy(new BooleanStubRandom(false));
        ladder.applyRungs(randomRungStrategy);

        LadderNavigator navigator = new LadderNavigator(ladder);
        LadderResults ladderResults = navigator.navigate();

        assertThat(ladderResults.getAll()).hasSize(3);

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            String result = results.get(i);
            assertThat(ladderResults.getByName(name)).isEqualTo(result);
        }
    }

}
