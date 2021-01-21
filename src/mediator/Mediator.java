package mediator;

import org.eclipse.swt.widgets.Composite;

import controller.AbstractExpertController;
import controller.ControllerCor;
import controller.ControllerSingleton;
import view.AbstractExpertSettingView;
import view.ExpertSettingViewCor;
import view.ExpertSettingViewSingleton;
import view.Win;

public class Mediator {
	Win view;
	Composite settingViewCurrent;
	AbstractExpertController expertController;
	AbstractExpertSettingView expert;
	
	public void setSettingView(String typePattern, Composite container) {
		expert = new ExpertSettingViewSingleton(null);
		expert = new ExpertSettingViewCor(expert);
		this.settingViewCurrent = expert.setSettingView(typePattern, container);

		//System.out.println(this.settingViewCurrent);
	}

	public void generate(String typePattern, String pathAbsoluteSrc) {
		expertController = new ControllerCor(null);
		expertController = new ControllerSingleton(expertController);
		
		expertController.generate(typePattern, pathAbsoluteSrc, settingViewCurrent);
	}
	
}
