package ladder.domain.ladder.unit;

public class Points {
    private final int startPoint;
    private int endPoint;
    
    private Points(int startPoint) {
        this.startPoint = startPoint;
    }
    
    public static Points from(int startPoint) {
        return new Points(startPoint);
    }
    
    public boolean isStartPoint(int startPoint) {
        return this.startPoint == startPoint;
    }
    
    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }
    
    public int getEndPoint() {
        return endPoint;
    }
}
