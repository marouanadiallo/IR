package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

import mediator.Mediator;

public class Win {

	protected Shell shlDesignPatterns;
	Display display = Display.getDefault();
	ContainerMenu containerMenu;
	ContainerBodySetting getPackage;
	Mediator mediator;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Win window = new Win();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		mediator = new Mediator();
		createContents();
		shlDesignPatterns.open();
		shlDesignPatterns.layout();
		while (!shlDesignPatterns.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDesignPatterns = new Shell(display, SWT.CLOSE | SWT.MIN);
		shlDesignPatterns.setSize(700, 650);
		shlDesignPatterns.setText("Design patterns");

		/**
		 * Center windows
		 */
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shlDesignPatterns.getBounds();

		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;

		shlDesignPatterns.setLocation(x, y);
		/***********************************************************/

		shlDesignPatterns.setLayout(new FillLayout(SWT.HORIZONTAL));
		Composite composite = new Composite(shlDesignPatterns, SWT.NONE);

		Composite containerSettingBody = new Composite(composite, SWT.NONE);
		containerSettingBody.setLocation(255, 0);
		containerSettingBody.setSize(437, 620);//503

		/***************************
		 * Button Generate and cancel
		 **************************************/
		Button btnGnrer = new Button(containerSettingBody, SWT.NONE);
		btnGnrer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (getGetPackage().getPathAbsolute() == null) {
					MessageBox messageBox = new MessageBox(shlDesignPatterns, SWT.ERROR | SWT.OK);
					messageBox.setText("Package n'est pas juste");
					messageBox.setMessage(
							"Veuillez choisir le package src de votre projet et le modèle que vous souhaitez générer.");
					int buttonID = messageBox.open();
					switch (buttonID) {
					case SWT.OK:
						btnGnrer.setEnabled(false);
					}
				} else {
					mediator.generate(getContainerMenu().getTree().getSelection()[0].getText(), //call mediator for generate code
							getPackage.getPathAbsolute());
					try {
						Thread.sleep(1000);
						shlDesignPatterns.dispose();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnGnrer.setBounds(178, 555, 136, 30);
		btnGnrer.setEnabled(false);
		btnGnrer.setText("G\u00E9n\u00E9rer et fermer");

		Button btnAnuller = new Button(containerSettingBody, SWT.NONE);
		btnAnuller.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlDesignPatterns.dispose();
			}
		});

		btnAnuller.setBounds(327, 555, 90, 30);
		btnAnuller.setText("Annuller");

		Composite containerSettingMenus = new Composite(composite, SWT.NONE);
		containerSettingMenus.setBounds(0, 0, 252, 620);

		/********************************
		 * Add my all views setting
		 *******************************************/
		getPackage = new ContainerBodySetting(containerSettingBody, SWT.NONE, btnGnrer);
		getPackage.setBounds(10, 10, 407, 112);
		

		Composite body = new Composite(containerSettingBody, SWT.NONE);
		body.setBounds(10, 135, 407, 540); 

		containerMenu = new ContainerMenu(containerSettingMenus, SWT.NONE, body, btnGnrer, mediator);
		body.setLayout(new StackLayout());
		containerMenu.setBounds(0, 0, 252, 610);

	}

	/**
	 * @return the containerMenu
	 */
	public ContainerMenu getContainerMenu() {
		return containerMenu;
	}

	/**
	 * @return the gethPackage
	 */
	public ContainerBodySetting getGetPackage() {
		return getPackage;
	}

}
