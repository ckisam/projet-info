package fr.sam;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import android.os.Bundle;
import fr.sam.core.BombaZebra;

public class AndroidLauncher extends AndroidApplication {

	// @Override
	// protected void onCreate (Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// AndroidApplicationConfiguration config = new
	// AndroidApplicationConfiguration();
	// initialize(new Bomberman(), config);
	// }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new BombaZebra(), config);
	}

}
