package fr.sam.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import fr.sam.core.BombaZebra;
import fr.sam.core.ZebraConstantes;

public class DesktopLauncher {

	// public static void main(String[] arg) {
	// LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	// config.title = "BombaZebra";
	// config.width = 960;
	// config.height = 640;
	// config.addIcon("icones/zebre128.png", FileType.Internal);
	// config.addIcon("icones/zebre32.png", FileType.Internal);
	// config.addIcon("icones/zebre16.png", FileType.Internal);
	// new LwjglApplication(new Bomberman(), config);
	// System.out.println("--------------------------------------------------");
	// System.out.println(GameConstants.SCREEN_WIDTH);
	// System.out.println(GameConstants.SCREEN_HEIGHT);
	// System.out.println("--------------------------------------------------");
	// }

	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "BombaZebra";
		config.width = ZebraConstantes.DESKTOP_INIT_WIDTH;
		config.height = ZebraConstantes.DESKTOP_INIT_HEIGHT;
		config.addIcon("icones/zebre128.png", FileType.Internal);
		config.addIcon("icones/zebre32.png", FileType.Internal);
		config.addIcon("icones/zebre16.png", FileType.Internal);
		new LwjglApplication(new BombaZebra(), config);
	}

}
