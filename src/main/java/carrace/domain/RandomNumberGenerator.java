package carrace.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 0;
    @Override
    public int generate() {
        return random.nextInt(MAX_RANDOM_NUMBER-MIN_RANDOM_NUMBER+1) + MIN_RANDOM_NUMBER;
    }
}
