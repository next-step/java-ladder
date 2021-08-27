package nextstep.laddergame.view;

import nextstep.laddergame.domain.PlayerName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @DisplayName("참여자 이름은 쉼표를 기준으로 입력된다.")
    @Test
    public void playerNamesInputTest() {
        List<String> names = Arrays.asList("abc", "def", "ghi", "jkl");
        List<PlayerName> expected = expectedPlayerNames(names);
        InputView inputView = InputView.of(new ByteArrayInputStream(String.join(",", names).getBytes()));
        List<PlayerName> playerNames = inputView.getPlayerNames();
        assertThat(playerNames)
                .hasSize(4)
                .containsAll(expected);
    }

    private List<PlayerName> expectedPlayerNames(List<String> names) {
        return names.stream()
                .map(PlayerName::of)
                .collect(Collectors.toList());
    }

}