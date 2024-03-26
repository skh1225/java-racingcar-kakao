package carrace.domain;

public class CarMoveRule {

    private static final int MOVE_THRESHOLD = 4;

    private final NumberGenerator numberGenerator;

    public CarMoveRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean isMovable() {
        return numberGenerator.generate() >= MOVE_THRESHOLD;
    }
}
