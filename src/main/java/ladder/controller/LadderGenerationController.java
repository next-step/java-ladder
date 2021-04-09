package ladder.controller;

import ladder.controller.dto.LadderGenerationRequest;
import ladder.controller.dto.LadderGenerationResponse;

import java.util.Arrays;

public class LadderGenerationController {

    public LadderGenerationResponse generateLadder(LadderGenerationRequest request) {
        return new LadderGenerationResponse(Arrays.asList("pobi", "honux", "crong", "jk"), 5); // TODO: 서비스레이어 실행결과 세팅
    }
}
