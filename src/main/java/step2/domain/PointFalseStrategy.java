package step2.domain;

public class PointFalseStrategy implements PointStrategy{
    @Override
    public boolean create() {
        return false;
    }
}
