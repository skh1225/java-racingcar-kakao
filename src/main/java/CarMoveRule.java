import java.util.Random;

public class CarMoveRule {

    private static final int MOVE_THRESHOLD = 4;

    public boolean move() {
        int value = generateValue();
        return move(value);
    }

    protected int generateValue() {
        return (new Random()).nextInt(10);
    }

    public boolean move(int value) {
        return value >= MOVE_THRESHOLD;
    }
}
