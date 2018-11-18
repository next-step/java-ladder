package domain;

import org.junit.Test;
import util.StringUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class ResultNameTagTest {
    @Test
    public void 결과목록만들기() {
        String names = "꽝,5000,꽝,3000";
        List<NameTag> nameTagGroup = StringUtil.makeNameTags(names);
        assertThat(3).isEqualTo(nameTagGroup.indexOf(NameTag.of("3000")));
    }
}