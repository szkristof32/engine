package szkristof.Engine.master.systems.events.window;

import szkristof.Engine.master.systems.events.Event;

public interface WindowFocusEvent {

	default void initEvent() {
		Event.addWindowFocusEvent(this);
	}
	
	public void invoke(long window);

}