package szkristof.Engine.master.systems.events.window;

import szkristof.Engine.master.systems.events.Event;

public interface WindowLostFocusEvent {

	default void initEvent() {
		Event.addWindowLostFocusEvent(this);
	}
	
	public void invoke(long window);

}