public class CarRaceApplication {
	public static void main(String[] args) {
		CarRaceView carRaceView = new CarRaceView();
		CarRaceController controller = new CarRaceController(carRaceView);
		controller.play();
	}
}
