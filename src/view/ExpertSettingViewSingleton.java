package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class ExpertSettingViewSingleton extends AbstractExpertSettingView{

	public ExpertSettingViewSingleton(AbstractExpertSettingView next) {
		super(next);
	}

	@Override
	public Composite setSettingViewContainer(String typePattern, Composite container) {
		if(typePattern.equalsIgnoreCase("singleton"))
		{
			ContainerBodySettingForSingleton s = new ContainerBodySettingForSingleton(container, SWT.NONE);
			s.setBounds(0, 0, 407, 330);
			System.out.println("dessin singleton setting");
			return s;
		}
		return null;
	}

}
