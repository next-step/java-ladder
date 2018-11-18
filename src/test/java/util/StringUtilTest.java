package util;

import domain.NameTag;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class StringUtilTest {
    @Test
    public void 사람목록만들기() {
        String names = "pobi,honux,crong,jk";
        List<NameTag> nameTagGroup = StringUtil.makeNameTags(names);
        assertThat(3).isEqualTo(nameTagGroup.indexOf(NameTag.of("jk")));
    }
}