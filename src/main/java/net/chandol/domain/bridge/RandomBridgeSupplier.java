package net.chandol.domain.bridge;

import net.chandol.value.Positive;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomBridgeSupplier implements BridgesSupplier {

    @Override
    public Bridges createBridges(Positive lineSize, Positive height) {
        List<Bridge> bridgeValues = RandomBridgesSupplierUtil.createRandomBridges(lineSize, height);
        return new Bridges(lineSize, height, bridgeValues);
    }

    static class RandomBridgesSupplierUtil {
        private static SecureRandom RANDOM = new SecureRandom();

        public static List<Bridge> createRandomBridges(Positive lineSize, Positive height) {
            return IntStream.range(0, height.value())
                    // 각 row별로 random값을 추출해낸다. 테스트불가능!
                    .mapToObj(row -> createRandomBridgesRow(lineSize.value(), row))
                    .flatMap(Collection::stream)
                    .collect(toList());
        }

        public static List<Bridge> createRandomBridgesRow(int size, int row) {
            List<Boolean> randomBooleans = getRandomBooleans(size);
            return randomBooleansToBridges(randomBooleans, row);
        }

        public static List<Boolean> getRandomBooleans(int size) {
            List<Boolean> booleans = RANDOM.ints(size - 1, 0, 10)
                    .mapToObj(i -> i > 6).collect(toList());

            return isBooleansConnected(booleans) ? getRandomBooleans(size) : booleans;
        }

        public static List<Bridge> randomBooleansToBridges(List<Boolean> rawBridges, int row) {
            return IntStream.range(0, rawBridges.size())
                    .filter(rawBridges::get)
                    .mapToObj(i -> Bridge.of(i, row))
                    .collect(toList());
        }

        public static boolean isBooleansConnected(List<Boolean> booleans) {
            for (int idx = 0; idx < (booleans.size() - 1); idx++) {
                if (booleans.get(idx) && booleans.get(idx + 1)) {
                    return true;
                }
            }

            return false;
        }
    }
}
