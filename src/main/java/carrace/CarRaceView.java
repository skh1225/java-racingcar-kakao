package carrace;

import carrace.domain.Car;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRaceView {

	private static final Scanner scanner = new Scanner(System.in);

	public List<String> getCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return Stream.of(scanner.nextLine().split(","))
			.collect(Collectors.toList());
	}

	public int getCarRaceRound() {
		System.out.println("시도할 횟수는 몇회인가요?");
		return Integer.parseInt(scanner.nextLine());
	}

	public void displayResultStartMessage() {
		System.out.println("\n실행 결과");
	}

	public void displayRoundResult(List<Car> cars) {
		cars.stream()
			.map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
			.forEach(System.out::println);
		System.out.println("");
	}

	public void displayWinnerNames(List<String> winnerNames) {
		System.out.printf("%s가 최종 우숭했습니다.", String.join(", ", winnerNames));
	}
}
