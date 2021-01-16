package controller;

import org.eclipse.swt.widgets.Composite;

public abstract class AbstractExpertController implements ExpertController {
	AbstractExpertController nextController;

	public AbstractExpertController(AbstractExpertController next) {
		this.nextController = next;
	}

	@Override
	public void generate(String typePattern, String pathAbsoluteSrc, Composite setting) {
		System.out.println(typePattern);
		boolean result = this.generateExpert(typePattern, pathAbsoluteSrc, setting);
		if (!result) {
			if(this.nextController != null) {
				this.nextController.generate(typePattern, pathAbsoluteSrc, setting);
			}
		}

	}

	public abstract boolean generateExpert(String typePattern, String pathAbsoluteSrc, Composite setting);
}
