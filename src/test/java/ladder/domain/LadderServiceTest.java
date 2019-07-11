package ladder.domain;

import ladder.RandomTestUtils;
import ladder.common.Csv;
import ladder.common.PositiveNumber;
import ladder.domain.user.Username;
import ladder.dto.LadderCreateRequestDto;
import ladder.dto.LadderCreateResponseDto;
import ladder.dto.LadderResultRequestDto;
import ladder.dto.LadderResultResponseDto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderServiceTest {

    @Test
    @DisplayName("사다리 게임이 정상적으로 처리되는지 확인한다")
    void startLadder() {

        //  a     b     c     d     e
        //  |-----|     |-----|     |
        //  |-----|     |-----|     |
        //  1     2     3     4     5
        LadderService ladderService = new DefaultLadderService(new DefaultLadderLineFactory(RandomTestUtils.TRUE));

        LadderCreateRequestDto ladderCreateRequestDto = LadderCreateRequestDto.of(
                Csv.ofString("john,bob,jinho,foo,bar"),
                Csv.ofString("1000,꽝,1000000,200,꽝"),
                PositiveNumber.of(2));
        LadderCreateResponseDto ladderCreateResponseDto = ladderService.createLadder(ladderCreateRequestDto);
        assertThat(ladderCreateResponseDto.getLadderLines().get().size()).isEqualTo(2);

        LadderResultRequestDto ladderResultRequestDto = LadderResultRequestDto.of("all");
        LadderResultResponseDto ladderResultResponseDto = ladderService.startLadder(ladderResultRequestDto);
        assertThat(ladderResultResponseDto.getLadderResult().findAll().get(Username.of("john"))).isEqualTo("1000");
        assertThat(ladderResultResponseDto.getLadderResult().findAll().get(Username.of("jinho"))).isEqualTo("1000000");
        assertThat(ladderResultResponseDto.getLadderResult().findAll().get(Username.of("bar"))).isEqualTo("꽝");
    }
}
