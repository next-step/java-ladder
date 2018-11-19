package domain;

import org.junit.Test;
import util.StringUtil;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LineTest {

    @Test
    public void 사다리높이검사() {

        String names = "pobi,honux,crong,jk";
        List<NameTag> nameTagGroup = StringUtil.makeNameTags(names);
        List<Boolean> booleanList = Arrays.asList(true, false, true, false);

        Line lines = Line.of(booleanList);
        int height = 5;
        Ladder ladder = Ladder.ofGroup(height, nameTagGroup);

        assertThat(ladder.getLines()).hasSize(height);
    }

    @Test
    public void 있어서는안될조건() {
        List<Boolean> booleanList = Arrays.asList(true, true, true);
        Line lines = Line.of(booleanList);
    }
}