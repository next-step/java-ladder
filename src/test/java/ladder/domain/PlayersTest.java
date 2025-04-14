package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class PlayersTest {
    @Test
    @DisplayName("중복된 Player를 제외한다.")
    void distinctPlayerTest() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Alice");
        Player player3 = new Player("Bob");

        Players players = new Players(List.of(player1, player2, player3));

        Assertions.assertEquals(players.countOfPlayer(), 2);
    }

    @Test
    @DisplayName("해당 이름의 플레이어의 인덱스를 반환한다.")
    void findIndexByNameTest_existName() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        Player player3 = new Player("Candy");
        Players players = new Players(List.of(player1, player2, player3));

        Optional<Integer> idx = players.findIndexByName("Alice");

        Assertions.assertTrue(idx.isPresent());
        Assertions.assertEquals(0, idx.get());
    }

    @Test
    @DisplayName("해당 이름의 플레이어가 없으면 빈 optional을 반환한다.")
    void findIndexByNameTest_notExistName() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        Player player3 = new Player("Candy");
        Players players = new Players(List.of(player1, player2, player3));

        Optional<Integer> idx = players.findIndexByName("Donny");

        Assertions.assertTrue(idx.isEmpty());
    }

}
