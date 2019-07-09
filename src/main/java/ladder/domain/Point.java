package ladder.domain;

public class Point {
    private Boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public Boolean getPoint() {
        return point;
    }

    public Point checkDuplicate(Point next){
        if(this.point== Boolean.TRUE && this.point.equals(next.point))
            return new Point(false);
        return next;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }
}
