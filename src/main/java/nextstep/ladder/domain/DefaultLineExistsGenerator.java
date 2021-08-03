package nextstep.ladder.domain;

public class DefaultLineExistsGenerator extends LineExistsGenerator {

    public boolean generate(boolean prev) {
        if (prev) {
            return false;
        }

        return RANDOM.nextBoolean();
    }
}
