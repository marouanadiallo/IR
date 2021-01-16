package view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;

public class ContainerBodySettingForSingleton extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ContainerBodySettingForSingleton(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Group grpSingletonSr = new Group(this, SWT.NONE);
		grpSingletonSr.setText("Singleton s\u00E9rialis\u00E9");
		
		Label lblSingletonImplmenteJavaioserializable = new Label(grpSingletonSr, SWT.NONE);
		lblSingletonImplmenteJavaioserializable.setBounds(10, 36, 384, 131);
		lblSingletonImplmenteJavaioserializable.setText("Le mod\u00E8le singleton qui sera g\u00E9n\u00E9rer impl\u00E9mente \r\njava.io.Serializable, pour des raisons de performance.\r\n\r\nPour des questions de s\u00E9curit\u00E9, on indique par la m\u00E9thode\r\n\"readResolve\" qui permet de personnalis\u00E9notre objet \r\nd\u00E9s\u00E9rialis\u00E9 afind'emp\u00EAcher la cr\u00E9ation d'un nouveau objet.");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
