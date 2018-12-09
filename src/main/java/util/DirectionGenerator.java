package util;

public class DirectionGenerator implements Generator {

    private final int weight;

    public DirectionGenerator(final int weight) {
        this.weight = weight;
    }

    @Override
    public boolean apply() {
        return RandomUtil.generate(weight);
    }

}
