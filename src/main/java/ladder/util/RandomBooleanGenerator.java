package ladder.util;

public class RandomBooleanGenerator implements BooleanGenerator{

    @Override
    public Boolean generate(){
        return Math.random() < 0.5;
    }
}
