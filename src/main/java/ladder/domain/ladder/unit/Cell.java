package ladder.domain.ladder.unit;

public class Cell {
    private final boolean rightConnected;
    private final boolean leftConnected;
    
    private Cell(final boolean rightConnected, final boolean leftConnected) {
        this.rightConnected = rightConnected;
        this.leftConnected = leftConnected;
    }
    
    public static Cell from(Cell cell, boolean connected) {
        if (cell.rightConnected) {
            return makeLeftConnectedCell();
        }
        
        return from(connected);
    }
    
    private static Cell makeRightConnectedCell() {
        return new Cell(true, false);
    }
    
    private static Cell makeLeftConnectedCell() {
        return new Cell(false, true);
    }
    
    public static Cell from(boolean connected) {
        if (connected) {
            return makeRightConnectedCell();
        }
        return new Cell(false, false);
    }
    
    public boolean isRightConnected() {
        return rightConnected;
    }
    
    public boolean isLeftConnected() {
        return leftConnected;
    }
}
