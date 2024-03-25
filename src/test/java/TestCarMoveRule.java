public class TestCarMoveRule extends CarMoveRule {

    private final boolean returnValue;

    public TestCarMoveRule(boolean returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public boolean move() {
        return returnValue;
    }
}
