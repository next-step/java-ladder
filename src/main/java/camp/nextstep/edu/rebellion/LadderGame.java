package camp.nextstep.edu.rebellion;

public class LadderGame {
    public static void main(String[] args) {
        Point[][] ladder = new Point[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ladder[i][j] = new Point();
            }
        }

        // 사다리를 다양하게 그리는 방법
        // 1. 시작점을 다르게 한다
        // 2. 그릴 수 있는 곳이지만 안그린다
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int up = (i - 1) < 0 ? 0 : (i - 1);
                int next = (j + 1);

                Point u = ladder[up][j]; //
                Point c = ladder[i][j];
                Point n = ladder[i][next];

                if (!c.prev
                        && !c.next
                        && !n.prev
                        && !u.next) {
                    c.next = true;
                    n.prev = true;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("|");
                int next = (j + 1);
                Point c = ladder[i][j];
                Point n = ladder[i][next];

                if (c.next && n.prev) {
                    System.out.print("-----");
                } else {
                    System.out.print("     ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static class Point {
        private int x;
        private int y;
        private boolean prev;
        private boolean next;
    }
}

/*
Row 는 Point 를 가지고 있다
Rows 는 무슨 역할을 할까??

좌표에 있는 점의 상태를 알려줌
Rows.getPointStatus(row, col);

해당 row에 있는 점의 상태를 알려줌
Row.getPoint(col);

Ladder
 - make
 - run
 - draw

LadderGame
 - 사용자 입력
 - 결과 출력

 */