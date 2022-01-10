package szkristof.Engine.master.systems.events.keyboard;

import szkristof.Engine.master.systems.events.EventType;

public class KeyReleasedEvent extends KeyEvent {

	public KeyReleasedEvent(int keyCode) {
		super(EventType.KEY_RELEASED, keyCode);
	}

	@Override
	public String toString() {
		return "KeyReleasedEvent: " + keyCode;
	}

}