import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLine {
    private static final int DO = 0;
    private static final int DO_OR_NOT = 2;

    private final List<Boolean> establishedResults;

    private LadderLine(List<Boolean> establishedResults){
        this.establishedResults = establishedResults;
    }

    private static List<Boolean> doLadderEstablish(int countOfColumn) {
        List<Boolean> results = new ArrayList<>(countOfColumn);
        Random random = new Random();

        for (int index = 0 ; index < countOfColumn ; index++) {
            boolean isDoEstablish = isPreviousNotEstablished(results, index) && isCanEstablish(random);
            results.add(isDoEstablish);
        }

        return results;
    }

    private static boolean isPreviousNotEstablished(List<Boolean> establishedResult, int currentIndex) {
        if (currentIndex == 0) {
            return true;
        }

        return !establishedResult.get(currentIndex - 1);
    }

    private static boolean isCanEstablish(Random random) {
        int randomNum = random.nextInt(DO_OR_NOT);
        return randomNum == DO;
    }

    public static LadderLine of(int countOfColumn) {
        List<Boolean> establishedResults = doLadderEstablish(countOfColumn);
        return new LadderLine(establishedResults);
    }

    public List<Boolean> getEstablishResults() {
        return Collections.unmodifiableList(this.establishedResults);
    }
}
