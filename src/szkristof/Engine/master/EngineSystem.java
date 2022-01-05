package szkristof.Engine.master;

/**
 * This class is the base class for a system in the engine. It can be initialised with the
 * {@link #init()} method. It updates with the {@link #update()} method, and at the end of the game
 * loop can be cleaned up with the {@link #cleanUp()} method. All the functionality must be
 * implemented in the classes that extend this base class.
 * 
 * @author szkristof
 *
 */
public interface EngineSystem {

	/**
	 * This method initialises the system. The initialisation code must be implemented in the class
	 * which extends this.
	 */
	public abstract void init();

	/**
	 * This method updates the system. The update code must be implemented in the class which extends
	 * this.
	 */
	public abstract void update();

	/**
	 * This method cleans the system up. The clean up code must be implemented in the class which
	 * extends this.
	 */
	public abstract void cleanUp();
	
	public default void preUpdate() {
		
	}
	
	public default void postUpdate() {
		
	}

}