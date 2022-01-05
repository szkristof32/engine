package szkristof.Engine.master.systems.events.window;

import szkristof.Engine.master.systems.events.Event;

public interface WindowMoveEvent {

	default void initEvent() {
		Event.addWindowMoveEvent(this);
	}
	
	public void invoke(long window);

}