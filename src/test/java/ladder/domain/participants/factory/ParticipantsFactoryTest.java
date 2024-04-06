package ladder.domain.participants.factory;

import ladder.domain.participants.Gamer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsFactoryTest {

    @Test
    void generate_gamers() {
        String pobi = "pobi";
        String honux = "honux";
        String crong = "crong";

        Gamer gamer0 = new Gamer(pobi, 0);
        Gamer gamer1 = new Gamer(honux, 1);
        Gamer gamer2 = new Gamer(crong, 2);

        assertThat(GamerFactory.generateGamers(new String[]{pobi, honux, crong}))
                .isEqualTo(List.of(gamer0, gamer1, gamer2));
    }
}