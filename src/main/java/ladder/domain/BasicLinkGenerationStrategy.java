package ladder.domain;

public class BasicLinkGenerationStrategy implements LinkGenerationStrategy {
    @Override
    public boolean isEnableToLink() {
        return (int) (Math.random() * 10) > 3;
    }
}
