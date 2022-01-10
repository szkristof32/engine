package szkristof.Engine.master.systems.events.keyboard;

import szkristof.Engine.master.systems.events.EventType;

public class KeyPressedEvent extends KeyEvent {

	private int repeatCount;
	
	public KeyPressedEvent(int keyCode, int repeatCount) {
		super(EventType.KEY_PRESSED, keyCode);
		this.repeatCount = repeatCount;
	}

	@Override
	public String toString() {
		return "KeyPressedEvent: " + keyCode + " (" + repeatCount + " repeats)";
	}

	public int getRepeatCount() {
		return repeatCount;
	}

}