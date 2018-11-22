package domain;

import org.junit.Before;
import org.junit.Test;
import utils.StringUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {
    List<NameTag> nameTags;
    NameTagGroup nameTagGroup;
    int height;
    @Before
    public void setUp() throws Exception {
       height = 1;
       nameTags = StringUtils.makeNameTag("faker,bang,wolf");
       nameTagGroup =  NameTagGroup.of(nameTags,height);
    }

    @Test
    public void 인덱스찾기() {
        String name = "bang";
        int index = nameTagGroup.indexOf(name);
        assertThat(index).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 인덱스찾기없는애찾기() {
        String name = "test";
        int index = nameTagGroup.indexOf(name);
        assertThat(index).isEqualTo(1);
    }

    @Test
    public void Difficult로찾기() {
        Difficult diff = Difficult.valueOf("상");
        Ladder.ofDifficult(5, diff);

        String name = "bang";
        int index = nameTagGroup.indexOf(name);
        assertThat(index).isEqualTo(1);
    }

}