package mediator;

import org.eclipse.swt.widgets.Composite;

import controller.AbstractExpertController;
import controller.ControllerCor;
import controller.ControllerSingleton;
import view.AbstractExpertSettingView;
import view.ExpertSettingViewCor;
import view.ExpertSettingViewSingleton;

public class Mediator {
	//Win view;
	Composite settingViewCurrent;
	
	AbstractExpertController expertController;
	AbstractExpertSettingView expertView;
	
	public void setSettingView(String typePattern, Composite container) {
		expertView = new ExpertSettingViewSingleton(null);
		expertView = new ExpertSettingViewCor(expertView);
		
		this.settingViewCurrent = expertView.setSettingView(typePattern, container);

		//System.out.println(this.settingViewCurrent);
	}

	public void generate(String typePattern, String pathAbsoluteSrc) {
		expertController = new ControllerCor(null);
		expertController = new ControllerSingleton(expertController);
		
		expertController.generate(typePattern, pathAbsoluteSrc, settingViewCurrent);
	}
	
}
