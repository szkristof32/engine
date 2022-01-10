package szkristof.Engine.master.systems.events;

public class EventCategory {

	public static final int NONE = 0;
	public static final int APPLICATION = BIT(0);
	public static final int INPUT = BIT(1);
	public static final int KEYBOARD = BIT(2);
	public static final int MOUSE = BIT(3);
	public static final int MOUSE_BUTTON = BIT(4);

	private static int BIT(int x) {
		return 1 << x;
	}

}