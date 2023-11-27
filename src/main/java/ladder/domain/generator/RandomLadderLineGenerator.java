package ladder.domain.generator;

import ladder.domain.LadderLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 랜덤으로 구성되는 사다리 라인 한 개를 만듭니다.
 */
public class RandomLadderLineGenerator implements Generator<LadderLine> {
    private static final Random RANDOM = new Random();

    private final int theNumberOfColumn;

    /**
     * 랜덤으로 사다리 라인을 생성하는 생성기를 만듭니다.
     *
     * @param theNumberOfColumn 이 생성기가 생성할 LadderLine의 컬럼 수
     */
    public RandomLadderLineGenerator(int theNumberOfColumn) {
        this.theNumberOfColumn = theNumberOfColumn;
    }


    @Override
    public LadderLine make() {
        return generateRandomLine(theNumberOfColumn);
    }

    /**
     * 주어진 컬럼 수를 가지는 사다리 라인을 랜덤으로 하나 만듭니다.
     *
     * @param theNumberOfColumn 컬럼 수
     *
     * @return 랜덤 사다리 라인
     */
    private static LadderLine generateRandomLine(int theNumberOfColumn) {
        if (theNumberOfColumn < 0) {
            throw new IllegalArgumentException("컬럼을 0개 이하로 지정할 수 없으나 " + theNumberOfColumn + "개로 지정되어 호출되었습니다.");
        }

        if (theNumberOfColumn == 1) {
            return LadderLine.of(new ArrayList<Boolean>());
        }


        List<Boolean> connectionInfo = new ArrayList<>(theNumberOfColumn-1);

        connectionInfo.add(determineRandomConnection());
        for (int i = 1; i < theNumberOfColumn - 1; i++) {
            connectionInfo.add(
                    tryConnect(determineRandomConnection(), connectionInfo.get(i-1))
            );
        }

        return LadderLine.of(connectionInfo);
    }

    /**
     * 이번에 연결할지 말지 판단합니다.
     *
     * @param isConnected 이번에 연결할지 말지를 나타내는 플래그입니다. 상황에 따라 연결을 요청해도 연결되지 않을 수 있습니다.
     * @param isConnectedWithBeforeColumn 이전 컬럼 연결 여부를 나타냅니다. 이전 컬럼과의 연결 여부가 다음 컬럼 연결에 영향을 미칩니다.
     *
     * @return 다음 컬럼과 연결할지 말지 계산된 값입니다. true면 연결을 false면 미연결을 의미합니다.
     */
    private static Boolean tryConnect(boolean isConnected, Boolean isConnectedWithBeforeColumn) {
        if (isConnectedWithBeforeColumn) {
            return false;
        }

        return isConnected;
    }

    private static boolean determineRandomConnection() {
        return RANDOM.nextBoolean();
    }
}