package nextstep.laddergame;

import nextstep.domain.LadderGame;
import nextstep.domain.GameUser;
import nextstep.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private LadderGame ladderGame;

    @BeforeEach
    void setup() {
        ladderGame = new LadderGame("Ben,Joy,Tom,Sunny","1등,꽝,2등,3등",5);
        ladderGame.makeLadderMap(5);

    }

    @Test
    void 사용자_생성_테스트() {
        assertThat(ladderGame.getUser("Ben")).isEqualTo(new GameUser("Ben"));
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
//        GameUser[] user = ladderGame.getUseGroup().toArray(new GameUser[ladderGame.getUseGroup().size()]);
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
        int firstRaw = ladderGame.getUser("Ben").getPosition().getRow();
        int firstCol = ladderGame.getUser("Ben").getPosition().getCol();
        int flag = 0;

        Boolean[][] map = {{new Boolean(Boolean.FALSE), new Boolean(Boolean.TRUE), new Boolean(Boolean.FALSE),new Boolean(Boolean.TRUE)},
                {new Boolean(Boolean.FALSE), new Boolean(Boolean.FALSE), new Boolean(Boolean.TRUE), new Boolean(Boolean.FALSE)},
                {new Boolean(Boolean.FALSE), new Boolean(Boolean.FALSE), new Boolean(Boolean.TRUE),new Boolean(Boolean.FALSE)},
                {new Boolean(Boolean.FALSE), new Boolean(Boolean.TRUE), new Boolean(Boolean.FALSE),new Boolean(Boolean.TRUE)},
                {new Boolean(Boolean.FALSE), new Boolean(Boolean.FALSE), new Boolean(Boolean.TRUE),new Boolean(Boolean.FALSE)}
        };

        System.out.println("시작Position: " + firstRaw + firstCol);


        for (int i = 0; i < ladderGame.getLadder().size(); ++i) {
            for (int j = 1; j < ladderGame.getUseGroup().size(); ++j) {
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
