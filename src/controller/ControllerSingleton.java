package controller;

import java.io.IOException;

import org.eclipse.swt.widgets.Composite;

import model.GenerateSingleton;

public class ControllerSingleton extends AbstractExpertController {

	public ControllerSingleton(AbstractExpertController next) {
		super(next);
	}

	@Override
	public boolean generateExpert(String typePattern, String pathAbsoluteSrc, Composite setting) {
		if (typePattern.equalsIgnoreCase("Singleton")) {
			try {
				GenerateSingleton.generateSingleton(pathAbsoluteSrc);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

}
