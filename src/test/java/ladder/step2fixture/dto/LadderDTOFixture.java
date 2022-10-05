package ladder.step2fixture.dto;

import ladder.step2.dto.LadderDTO;
import ladder.step2fixture.domain.LadderFixture;

public class LadderDTOFixture {
    public static final LadderDTO LADDER_DTO = new LadderDTO(LadderFixture.LADDER.ladderInformation().getLines());
}
