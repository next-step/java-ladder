package ladderapplication.validator;

import ladderapplication.models.requests.PlayerRequest;

public class PlayerRequestValidator {

    private static final String WRONG_NAME = "플레이어 이름음 5글자 이하 여야 합니다.";

    public static void validation(PlayerRequest playerRequest) {
        if (playerRequest.getName().length() > 5) {
            throw new IllegalArgumentException(WRONG_NAME);
        }
    }

}
