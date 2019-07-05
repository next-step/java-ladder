package laddertest;

import ladder.domain.LadderFactory;
import ladder.domain.SingleUser;
import ladder.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderFactoryTest {
    private LadderFactory ladderFactory;

    @BeforeEach
    void setup() {
        ladderFactory = new LadderFactory("Ben,Joy,Tom,Sunny","1등,꽝,2등,3등",5);
        ladderFactory.makeLadderMap(5);

    }

    @Test
    void 사용자_생성_테스트() {
        assertThat(ladderFactory.getUser("Ben")).isEqualTo(new SingleUser("Ben"));
    }

    @Test
    void 인접좌표와_중복된_값이_추가되면_반대값으로_() {
        Line ladder = new Line();
        ladder.getPoints().add(Boolean.TRUE);
        ladder.getPoints().add(Boolean.FALSE);
        ladder.getPoints().add(Boolean.TRUE);

        Boolean element = Boolean.TRUE;
        ladder.checkElement(ladder.getPoints().get(2), element);
        assertThat(ladder.checkElement(ladder.getPoints().get(2), element)).isEqualTo(new Boolean(Boolean.FALSE));
    }

//    @Test
//    void 참가자_출발좌표_구하기() {
//        int row = 0;
//        int col = 0;
//
//
//        SingleUser[] user = ladderFactory.getUseGroup().toArray(new SingleUser[ladderFactory.getUseGroup().size()]);
//
//        for (int i = 0; i < user.length; ++i) {
//            if (user[i].getName().equals("Joy")) {
//                row = i;
//            }
//        }
//
//        assertThat(row).isEqualTo(1);
//    }

    @Test
    void 경로구하기() {
        int firstRaw = ladderFactory.getUser("Ben").getPosition().getRow();
        int firstCol = ladderFactory.getUser("Ben").getPosition().getCol();
        int flag = 0;

        Boolean[][] map = {{new Boolean(Boolean.FALSE), new Boolean(Boolean.TRUE), new Boolean(Boolean.FALSE),new Boolean(Boolean.TRUE)},
                {new Boolean(Boolean.FALSE), new Boolean(Boolean.FALSE), new Boolean(Boolean.TRUE), new Boolean(Boolean.FALSE)},
                {new Boolean(Boolean.FALSE), new Boolean(Boolean.FALSE), new Boolean(Boolean.TRUE),new Boolean(Boolean.FALSE)},
                {new Boolean(Boolean.FALSE), new Boolean(Boolean.TRUE), new Boolean(Boolean.FALSE),new Boolean(Boolean.TRUE)},
                {new Boolean(Boolean.FALSE), new Boolean(Boolean.FALSE), new Boolean(Boolean.TRUE),new Boolean(Boolean.FALSE)}
        };

        System.out.println("시작Position: " + firstRaw + firstCol);


        for (int i = 0; i < ladderFactory.getLadder().size(); ++i) {
            for (int j = 1; j < ladderFactory.getUseGroup().size(); ++j) {
                System.out.println("Map[" + i + "][" + j + "]: " + map[i][j]);

                if (firstCol == j && map[i][j].equals(Boolean.TRUE)) {
                    firstRaw += 1;
                    firstCol -= 1;
                    flag += 1;
                    System.out.println("Left&& 현재 Position: " + firstRaw + firstCol + flag);
                    break;
                }
                if (firstCol + 1 == j && map[i][j].equals(Boolean.TRUE)) {
                    firstRaw += 1;
                    firstCol += 1;
                    flag += 1;
                    System.out.println("Right && 현재 Position: " + firstRaw + firstCol + flag);
                    break;
                }
            }
            if (flag == i ) {
                firstRaw += 1;
                flag += 1;
                System.out.println("직진 && 현재 Position: " + firstRaw + firstCol+ flag);
            }
        }


        System.out.println("마지막 Position: " + firstRaw + firstCol+ flag);
    }


}
