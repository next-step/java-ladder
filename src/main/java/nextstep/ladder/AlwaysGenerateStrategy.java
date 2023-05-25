package nextstep.ladder;

public class AlwaysGenerateStrategy implements GenerationStrategy{

    @Override
    public boolean shouldPlace(boolean isPlaceable) {
        return isPlaceable;
    }
}
