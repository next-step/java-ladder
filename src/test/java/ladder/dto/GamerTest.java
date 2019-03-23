package ladder.dto;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GamerTest {

    @Test
    public void 가장긴이름가져오기() {
        List<Gamer> gamers = Arrays.asList(new Gamer("aaaaa"), new Gamer("bbb"), new Gamer("cccc"), new Gamer("dd"));
        gamers.sort(Comparator.reverseOrder());
        assertThat(gamers.get(0).getNameLength()).isEqualTo(5);
    }

}