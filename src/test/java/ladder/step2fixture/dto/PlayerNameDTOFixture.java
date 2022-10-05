package ladder.step2fixture.dto;

import ladder.step2.dto.PlayerNameDTO;
import ladder.step2fixture.domain.PlayerNameFixture;

public class PlayerNameDTOFixture {
    public static final PlayerNameDTO PLAYER_NAME_DTO_JUN = new PlayerNameDTO(PlayerNameFixture.JUN.playerNameInformation().getPlayerName());
}
