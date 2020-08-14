package camp.nextstep.edu.rebellion;

public class LadderGameRunner {
    public static void main(String[] args) {
        Point[][] ladder = new Point[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ladder[i][j] = new Point();
            }
        }


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