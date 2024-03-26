package carrace.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 1;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d글자 이하여야합니다.", MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position++;
    }
}
