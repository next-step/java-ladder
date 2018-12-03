package net.chandol.ladder.v2.domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static net.chandol.ladder.v2.domain.RandomLinesGenerator.RandomBridgesSupplierUtil.convertToLines;
import static net.chandol.ladder.v2.domain.RandomLinesGenerator.RandomBridgesSupplierUtil.createRandomRawLines;

public class RandomLinesGenerator implements LinesGenerator {
    @Override
    public List<Line> generate(int size, int height) {
        List<List<Boolean>> rawLines = createRandomRawLines(size, height);
        return convertToLines(rawLines);
    }

    static class RandomBridgesSupplierUtil {
        private static SecureRandom RANDOM = new SecureRandom();

        public static List<Line> convertToLines(List<List<Boolean>> rawLines) {
            return rawLines.stream().map(Line::new).collect(toList());
        }

        // 복잡도를 어떻게 하면 줄일 수 있는지 고민할 것.
        public static List<List<Boolean>> createRandomRawLines(int size, int height) {
            List<List<Boolean>> rawLines = new ArrayList<>();
            IntStream.range(0, size).forEach(i -> rawLines.add(new ArrayList<>()));
            IntStream.range(0, height).forEach(row -> {
                List<Boolean> booleans = generateRandomPoints(size);
                for (int idx = 0; idx < size; idx++) {
                    rawLines.get(idx).add(booleans.get(idx));
                }
            });

            return rawLines;
        }

        public static List<Boolean> generateRandomPoints(int size) {
            List<Boolean> booleans = RANDOM.ints(size - 1, 0, 10)
                    .mapToObj(i -> i > 6).collect(toList());

            // 항상 마지막 값을 추가시켜 준다.
            booleans.add(false);

            return isBooleansContinuance(booleans) ? generateRandomPoints(size) : booleans;
        }

        public static boolean isBooleansContinuance(List<Boolean> booleans) {
            for (int idx = 0; idx < (booleans.size() - 1); idx++) {
                if (booleans.get(idx) && booleans.get(idx + 1)) {
                    return true;
                }
            }

            return false;
        }
    }
}
