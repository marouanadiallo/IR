package view;

import org.eclipse.swt.widgets.Composite;

public abstract class AbstractExpertSettingView implements ExpertSettingView{
	AbstractExpertSettingView next;
	
	public AbstractExpertSettingView(AbstractExpertSettingView next) {
		this.next = next;
	}
	
	@Override
	public Composite setSettingView(String typePattern, Composite container) {
		Composite result = this.setSettingViewContainer(typePattern, container);
		
		if(result != null)
		{
			return result;
		}
		else {
			if(this.next != null)
				return this.next.setSettingView(typePattern, container);
			else
				return null;
		}
	}
	public abstract Composite setSettingViewContainer(String typePattern, Composite container);
}
