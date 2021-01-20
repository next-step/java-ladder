package ladder.util;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void splitNames() {
        String names = "morr,dd,dell";
        String[] strings = StringUtil.splitNames(names);
        assertAll(
                ()-> { strings[0].equals("morr");},
                ()-> { strings[1].equals("dd");}
            );

    }

    @Test
    void splitNamesNull_Exception() {
        String names = "";
        assertThrows(NullPointerException.class,()->{
            StringUtil.splitNames(names);
        });
    }
}