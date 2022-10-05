package ladder.step2fixture.dto;

import ladder.step2.dto.LineDTO;
import ladder.step2fixture.domain.LineFixture;

public class LineDTOFixture {
    public static final LineDTO LINE_DTO = new LineDTO(LineFixture.LINE.lineInformation().getPartLines());
}
