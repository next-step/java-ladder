package nextstep.ladder.domain.wrapper;

import nextstep.ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    @DisplayName("서로 다른 이름의 Player를 생성한다.")
    @Test
    void creatPlayers() {
        String[] names = {"홍길동", "전창길", "코난"};

        assertThat(
            new Players(IntStream.range(0, names.length)
                .mapToObj(i -> Player.PlayerBuilder.builder()
                    .name(names[i])
                    .widthPosition(i)
                    .heightPosition(1)
                    .build())
                .collect(Collectors.toList())))
        .isEqualTo(
            new Players(IntStream.range(0, names.length)
                .mapToObj(i -> Player.PlayerBuilder.builder()
                    .name(names[i])
                    .widthPosition(i)
                    .heightPosition(1)
                    .build())
                .collect(Collectors.toList()))
        );
    }

    @DisplayName("플레이어들의 이름이 같으면 예외를 발생시킨다.")
    @Test
    void creatPlayersWhenSameName() {
        // given
        String[] names = {"홍길동", "홍길동", "코난"};

        // when & then
        assertThatThrownBy(() -> new Players(IntStream.range(0, names.length)
            .mapToObj(i -> Player.PlayerBuilder.builder()
                .name(names[i])
                .widthPosition(i)
                .heightPosition(1)
                .build())
            .collect(Collectors.toList()))).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NOT_EQUAL_NAME.message());
    }
}
