package nextstep.ladder.domain.resolver;

import nextstep.ladder.domain.generator.LadderGenerator;
import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.name.Names;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResolverTest {

    @Test
    public void 단건으로_사람들의_정보가_입력되면_중복없는_결과를_리턴한다() {
        Names names = new Names("aaa, bbb, ccc");
        Height height = new Height(5);
        Ladder ladder = LadderGenerator.generateLadder(names.count(), height);
        LadderResolver resolver = new LadderResolver(ladder);

        Set setList = new HashSet();
        for(int i = 0; i < names.count(); i++) {
            int result = resolver.resultOf(i);
            setList.add(result);
        }

        assertThat(setList).hasSize(3);
    }

    @Test
    public void 전체_사람들의_정보가_입력되면_중복없는_결과를_리턴한다() {
        Names names = new Names("aaa, bbb, ccc");
        Height height = new Height(5);
        Ladder ladder = LadderGenerator.generateLadder(names.count(), height);
        LadderResolver resolver = new LadderResolver(ladder);

        List<Integer> results = resolver.all();

        Set setList = new HashSet();
        for(Integer result: results) {
            setList.add(result);
        }

        assertThat(setList).hasSize(3);
    }
}
