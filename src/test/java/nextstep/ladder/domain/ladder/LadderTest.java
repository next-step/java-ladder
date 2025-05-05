package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.generator.LadderGenerator;
import nextstep.ladder.domain.name.Names;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    public void 단건으로_사람들의_정보가_입력되면_중복없는_결과를_리턴한다() {
        Names names = new Names("aaa, bbb, ccc");
        Height height = new Height(5);
        Ladder ladder = LadderGenerator.generateLadder(names.count(), height);

        Set<Integer> setList = new HashSet<>();
        for(int i = 0; i < names.count(); i++) {
            Index result = ladder.resultOf(i);
            setList.add(result.value());
        }

        assertThat(setList).hasSize(3);
    }

    @Test
    public void 전체_사람들의_정보가_입력되면_중복없는_결과를_리턴한다() {
        Names names = new Names("aaa, bbb, ccc");
        Height height = new Height(5);
        Ladder ladder = LadderGenerator.generateLadder(names.count(), height);

        List<Index> results = ladder.all();

        Set<Integer> setList = new HashSet<>();
        for(Index result: results) {
            setList.add(result.value());
        }

        assertThat(setList).hasSize(3);
    }
}