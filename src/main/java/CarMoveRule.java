import java.util.Random;

public class CarMoveRule {

    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_VALUE = 9;

    public static boolean move(int value) {
        return value >= MOVE_THRESHOLD;
    }

    public static boolean move() {
        int value = (new Random()).nextInt(MAX_VALUE + 1);
        return move(value);
    }
}
