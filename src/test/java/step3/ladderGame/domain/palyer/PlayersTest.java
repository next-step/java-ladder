package step3.ladderGame.domain.palyer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(new Players("qwe,asd,zxc,ert")).isInstanceOf(Players.class);
    }

    @DisplayName("해당 이름의 인덱스를 조회")
    @ParameterizedTest
    @CsvSource(value = {"qwe:0", "asd:1", "zxc:2", "sdf:3"}, delimiter = ':')
    void findIndex(String name, int index) {
        Players players = new Players("qwe,asd,zxc,sdf");
        assertThat(players.findIndex(name)).isEqualTo(index);
    }

}
