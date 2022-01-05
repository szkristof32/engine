package szkristof.Engine.master.systems.events.window;

import szkristof.Engine.master.systems.events.Event;

public interface WindowResizeEvent {

	default void initEvent() {
		Event.addWindowResizeEvent(this);
	}
	
	public void invoke(long window, int width, int height);

}