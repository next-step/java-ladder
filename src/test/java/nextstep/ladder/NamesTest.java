package nextstep.ladder;

import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    @Test
    @DisplayName("이름은 쉼표로 분리된다")
    void 이름_분리(){
        String names = "sysy,dong,meme";
        assertThat(new Names(names).names()).isEqualTo(Arrays.asList(new Name("sysy"),new Name("dong"), new Name("meme")));

    }
}
