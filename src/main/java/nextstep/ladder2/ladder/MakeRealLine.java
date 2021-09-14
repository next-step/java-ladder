package nextstep.ladder2.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeRealLine implements LineMaker {

    Random random = new Random();

    public boolean makeLine(boolean preStatus){
        if(preStatus){
            return false;
        }
        return random.nextBoolean();
    }
}
