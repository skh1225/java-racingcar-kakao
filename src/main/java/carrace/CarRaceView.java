package carrace;

import carrace.domain.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRaceView {

	private static final Scanner scanner = new Scanner(System.in);

	public List<String> getCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		List<String> carNames = Stream.of(scanner.nextLine().split(",")).collect(Collectors.toList());
		for (String carName : carNames) {
			validateName(carName);
		}
		validateDuplicateNames(carNames);
		return carNames;
	}

	public void validateName(String carName) {
		if (carName.length() > 5) {
			throw new IllegalArgumentException("자동차의 이름은 5자이하여야 합니다.");
		}

		if (carName.isEmpty()) {
			throw new IllegalArgumentException("자동차의 이름은 공백이 아니여야 합니다.");
		}
	}

	public void validateDuplicateNames(List<String> carNames) {
		Set<String> carNamesSet = new HashSet<>(carNames);
		if (carNames.size() != carNamesSet.size()) {
			throw new IllegalArgumentException("중복된 이름이 존재합니다.");
		}
	}

	public int getCarRaceRound() {
		System.out.println("시도할 횟수는 몇회인가요?");
		int round = Integer.parseInt(scanner.nextLine());
		validateRaceRound(round);
		return round;
	}

	public void validateRaceRound(int round) {
		if (round <= 0) {
			throw new IllegalArgumentException("라운드는 양수여야 합니다.");
		}
	}

	public void displayResultStartMessage() {
		System.out.println("\n실행 결과");
	}

	public void displayRoundResult(List<Car> cars) {
		cars.stream()
			.map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
			.forEach(System.out::println);
		System.out.println();
	}

	public void displayWinnerNames(List<String> winnerNames) {
		System.out.printf("%s가 최종 우숭했습니다.", String.join(", ", winnerNames));
	}
}
