package nextstep.ladder.model.v2;

public class AllFalseLadderPointGenerator implements LadderPointGenerator {
    @Override
    public boolean generatePoint() {
        return false;
    }
}
