package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class ExpertSettingViewCor extends AbstractExpertSettingView{

	public ExpertSettingViewCor(AbstractExpertSettingView next) {
		super(next);
	}

	@Override
	public Composite setSettingViewContainer(String typePattern, Composite container) {
		if(typePattern.equalsIgnoreCase("chaine de responsabilité"))
		{
			ContainerBodySettingForCOR<?> cor = new ContainerBodySettingForCOR<>(container, SWT.NONE);
			cor.setBounds(0, 0, 407, 330);
			System.out.println("dessin cor setting");
			return cor;
		}
		return null;
	}

}
