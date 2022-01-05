package szkristof.Sandbox.main;

public class Main {

	public static void main(String[] args) {

		Game game = new Game();
		game.init();

		while (!game.gameShouldTerminate()) {
			game.update();
		}

		game.cleanUp();
	}

}