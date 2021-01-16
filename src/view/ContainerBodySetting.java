package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ContainerBodySetting extends Composite {
	private Text srcPath;
	private String pathAbsolute;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ContainerBodySetting(Composite parent, int style, Shell mainCard, Button btnGenerate) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Group grpPackage = new Group(this, SWT.NONE);
		grpPackage.setText("Package");

		Label lblIndiquerLeChemin = new Label(grpPackage, SWT.NONE);
		lblIndiquerLeChemin.setBounds(10, 21, 387, 30);
		lblIndiquerLeChemin.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblIndiquerLeChemin.setText("Indiquer le chemin du package \"src\" de votre projet.");

		Label lblSrc = new Label(grpPackage, SWT.CENTER);
		lblSrc.setBounds(10, 57, 39, 30);
		lblSrc.setAlignment(SWT.CENTER);
		lblSrc.setText("Src : ");

		srcPath = new Text(grpPackage, SWT.BORDER | SWT.READ_ONLY);
		srcPath.setBounds(51, 57, 252, 30);

		Button btnOuvrir = new Button(grpPackage, SWT.NONE);
		btnOuvrir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dlg = new DirectoryDialog(mainCard);

				dlg.setFilterPath(srcPath.getText());
				dlg.setText("Selectionner le package src de votre projet");
				
				String dir = dlg.open();
				if (dir != null) {
					if(!dir.substring(dir.length()-3).equalsIgnoreCase("src"))
					{
						MessageBox messageBox = new MessageBox(mainCard, SWT.ERROR | SWT.OK);
						messageBox.setText("Package n'est pas juste");
				        messageBox.setMessage("Veuillez choisir le package src de votre projet.");
				        int buttonID = messageBox.open();
				        switch(buttonID) {
				          case SWT.OK :
				        	  srcPath.setText("");
				        	  btnGenerate.setEnabled(false);
				        }
					}
					else
					{
						srcPath.setText(dir);
						pathAbsolute = srcPath.getText();
						btnGenerate.setEnabled(true);
					}
					
				}
			}
		});
		btnOuvrir.setBounds(309, 57, 90, 30);
		btnOuvrir.setText("ouvrir...");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * @return the pathAbsolute
	 */
	public String getPathAbsolute() {
		return pathAbsolute;
	}

}
