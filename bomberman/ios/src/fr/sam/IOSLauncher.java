package fr.sam;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;

import fr.sam.core.BombaZebra;

public class IOSLauncher extends IOSApplication.Delegate {

	// @Override
	// protected IOSApplication createApplication() {
	// IOSApplicationConfiguration config = new IOSApplicationConfiguration();
	// return new IOSApplication(new Bomberman(), config);
	// }

	@Override
	protected IOSApplication createApplication() {
		IOSApplicationConfiguration config = new IOSApplicationConfiguration();
		return new IOSApplication(new BombaZebra(), config);
	}

	public static void main(String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, IOSLauncher.class);
		pool.close();
	}

}