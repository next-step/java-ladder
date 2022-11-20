package nextstep.ladder;

import nextstep.ladder.domain.Names;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    @Test
    void 이름을_입력_받는다(){
        String names = "sienna,dong,meme";
        assertThat(new Names(names).names()).isEqualTo("sienna,dong,meme");

    }
}
