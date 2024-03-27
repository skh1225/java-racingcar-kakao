package carrace.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position = 1;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int moveForward() {
        return ++position;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차의 이름은 %d이하여야 합니다.", MAX_NAME_LENGTH));
        }
    }
}
