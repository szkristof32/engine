package szkristof.Engine.master.systems.events.mouse;

import szkristof.Engine.master.systems.events.EventType;

public class MouseButtonPressedEvent extends MouseButtonEvent {

	public MouseButtonPressedEvent(int button) {
		super(EventType.MOUSE_BUTTON_PRESSED, button);
	}

	@Override
	public String toString() {
		return "MouseButtonPressedEvent: " + button;
	}

}