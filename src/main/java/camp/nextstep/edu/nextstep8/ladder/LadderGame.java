package camp.nextstep.edu.nextstep8.ladder;

public class LadderGame {
    private static final String LINE = "-----";
    private static final String SPACE = "     ";
    private static Point[][] points = new Point[5][4]; // height 5, member 4

    static void initPointsMap(Point[][] points) {
        for(int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = new Point();
            }
        }
    }

    public static void main(String[] args) {
        initPointsMap(points);
        makeLadder();

        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points[i].length; j++) {
                System.out.print("|");
                System.out.print(getPrintLine(i, j));
            }
            System.out.println();
        }
    }

    static void makeLadder() {
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points[i].length; j++) {
                if(canDrawLine(i, j)) {
                    drawLine(i, j);
                }
            }
        }
    }

    static String getPrintLine(int row, int order) {
        if(canPrintLine(row, order)) {
            return LINE;
        }
        return SPACE;
    }


    static boolean canPrintLine(int row, int order) {
        if(meetLastOrder(order)) {
            return false;
        }
        return points[row][order].hasRightLine() && points[row][order + 1].hasLeftLine();
    }

    static boolean canDrawLine(int row, int order){
        if(meetLastOrder(order)) {
            return false;
        }
        if(isAlreadyDraw(row, order)) {
            return false;
        }
        return true;
     }

     static boolean isAlreadyDraw(int row, int order) {
        return points[row][order].hasLeftLine();
     }

    static boolean meetLastOrder(int order) {
        int nextOrder = order + 1;
        if(4 <= nextOrder) {
            return true;
        }
        return false;
    }

    static void drawLine(int row, int order) {
        if(meetLastOrder(order)) {
            return;
        }
        points[row][order].markStart();
        points[row][order + 1].markEnd();
    }
}
