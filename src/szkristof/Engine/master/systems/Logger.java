package szkristof.Engine.master.systems;

import java.sql.Time;
import java.time.LocalTime;

import szkristof.Engine.master.EngineSystem;

/**
 * The logger can log some warning or error messages to the console helping the debugging. Using the
 * {@link #info(String)} method the logger prints a plain white message, the {@link #warn(String)}
 * method prints a yellow message, and the {@link #error(String)} method prints an error message.
 * The default format of the messages is <b>&#0132;[{@code time}] {@code name}:
 * {@code message}&#0148;</b>, where {@code name} is the name of the logger, {@code time} is the
 * current timestamp and {@code message} is the message the method gets in as an argument.
 * 
 * @author szkristof
 *
 */
@SuppressWarnings("unused")
public class Logger implements EngineSystem {

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_PURPLE = "\u001B[35m";
	private static final String ANSI_CYAN = "\u001B[36m";
	private static final String ANSI_WHITE = "\u001B[37m";

	private String name;
	private StringBuilder builder;

	/**
	 * The constructor just initialises the fields, the name and a {@code StringBuilder}
	 * 
	 * @param name
	 */
	public Logger(String name) {
		this.name = name;
		this.builder = new StringBuilder();
	}

	@Override
	public void init() {

	}

	@Override
	public void update() {

	}

	@Override
	public void cleanUp() {

	}

	/**
	 * The method prints a plain white message in the format that specified at the docs of the class
	 * 
	 * @param message
	 */
	public void info(String message) {
		builder.delete(0, builder.capacity());
		setColour(ANSI_WHITE);
		log(message);
		System.out.println(builder);
	}

	/**
	 * The method prints a yellow message in the format that specified at the docs of the class
	 * 
	 * @param message
	 */
	public void warn(String message) {
		builder.delete(0, builder.capacity());
		setColour(ANSI_YELLOW);
		log(message);
		System.out.println(builder);
	}

	/**
	 * The method prints a red message in the format that specified at the docs of the class
	 * 
	 * @param message
	 */
	public void error(String message) {
		builder.delete(0, builder.capacity());
		setColour(ANSI_RED);
		log(message);
		System.out.println(builder);
	}

	private void setColour(String colour) {
		builder.append(colour);
	}

	private void log(String message) {
		builder.append("[" + Time.valueOf(LocalTime.now()) + "] ");
		builder.append(name).append(": ");
		builder.append(message);
		setColour(ANSI_RESET);
	}

}