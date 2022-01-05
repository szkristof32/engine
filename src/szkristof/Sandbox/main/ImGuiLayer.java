package szkristof.Sandbox.main;

import org.lwjgl.glfw.GLFW;

import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.flag.ImGuiBackendFlags;
import imgui.flag.ImGuiConfigFlags;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
import szkristof.Engine.master.GameManager;
import szkristof.Engine.master.layers.Layer;
import szkristof.Engine.master.systems.Window;

public class ImGuiLayer extends Layer {

	private final ImGuiImplGlfw imGuiGlfw = new ImGuiImplGlfw();
	private final ImGuiImplGl3 imGuiGl3 = new ImGuiImplGl3();

	private String glslVersion = "#version 410";

	public ImGuiLayer() {
		super("ImGuiLayer");
	}

	@Override
	public void onAttach() {
		ImGui.createContext();
		ImGui.styleColorsClassic();
		ImGuiIO io = ImGui.getIO();
		io.addBackendFlags(ImGuiBackendFlags.HasMouseCursors);
		io.addBackendFlags(ImGuiBackendFlags.HasSetMousePos);
		io.addConfigFlags(ImGuiConfigFlags.ViewportsEnable);
		imGuiGlfw.init(GameManager.getStaticWindow().getId(), true);
		imGuiGl3.init(glslVersion);
	}

	@Override
	public void onDetach() {
		imGuiGl3.dispose();
		imGuiGlfw.dispose();
		ImGui.destroyContext();
	}

	@Override
	public void onUpdate() {
		imGuiGlfw.newFrame();
		ImGui.newFrame();

		ImGuiIO io = ImGui.getIO();
		Window window = GameManager.getStaticWindow();
		io.setDisplaySize(window.getWidth(), window.getHeight());
		io.setDeltaTime(GameManager.getInstance().getDeltaTime());

		ImGui.showDemoWindow();

		ImGui.render();
		imGuiGl3.renderDrawData(ImGui.getDrawData());
		if (ImGui.getIO().hasConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
			final long backupWindowPtr = GLFW.glfwGetCurrentContext();
			ImGui.updatePlatformWindows();
			ImGui.renderPlatformWindowsDefault();
			GLFW.glfwMakeContextCurrent(backupWindowPtr);
		}
	}

}