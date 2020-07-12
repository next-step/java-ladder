package nextstep.ladder.domain;

public interface Ladder {

    static Ladder newLadder(LadderMaterials ladderMaterials) {
        return null;
    }

    LadderResult exec();
}
