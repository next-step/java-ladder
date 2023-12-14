package ladderWithInterface.custom;

import ladderWithInterface.engin.CoordinateGenerator;

public class ManualCoordinateGenerator implements CoordinateGenerator {
    @Override
    public boolean generate() {
        return true;
    }
}
