package nextstep.ladder.dto;

import nextstep.ladder.domain.ladder.DirectionStrategy;
import nextstep.ladder.domain.ladder.LadderMaterial;
import nextstep.ladder.domain.ladder.LineMaterial;
import nextstep.ladder.domain.ladderGame.LadderGameInfo;
import nextstep.ladder.domain.ladderGame.LadderRewards;
import nextstep.ladder.domain.ladderGame.Players;

public class LadderRequest {
    private static final String SEPARATOR = ",";

    private final String inputNames;
    private final String inputRewards;
    private final int inputHeight;

    public LadderRequest(final String inputNames, final String inputRewards, final int inputHeight) {
        this.inputNames = inputNames;
        this.inputRewards = inputRewards;
        this.inputHeight = inputHeight;
    }

    public LadderGameInfo toLadderGameInfo() {
        Players players = Players.of(inputNames, SEPARATOR);
        LadderRewards ladderRewards = LadderRewards.of(inputRewards, SEPARATOR);
        return new LadderGameInfo(players, ladderRewards);
    }

    public LadderMaterial toLadderMaterial(DirectionStrategy directionStrategy) {
        int sizeOfPoint = inputNames.split(SEPARATOR).length;
        LineMaterial lineMaterial = LineMaterial.of(sizeOfPoint, directionStrategy);
        return LadderMaterial.of(inputHeight, lineMaterial);
    }
}
