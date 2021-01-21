package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import mediator.Mediator;

public class ContainerMenu extends Composite {
	Tree menu;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ContainerMenu(Composite parent, int style, Composite containerBody, Button btnGenerate, Mediator mediator) {

		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		menu = new Tree(this, SWT.BORDER | SWT.FULL_SELECTION);

		TreeItem creatonalPatterns = new TreeItem(menu, SWT.NONE);
		creatonalPatterns.setText("Modèles de création");

		TreeItem creatonalPatternSingleton = new TreeItem(creatonalPatterns, SWT.NONE);
		creatonalPatternSingleton.setText("Singleton");
		creatonalPatterns.setExpanded(true);

		TreeItem behavioralPatterns = new TreeItem(menu, SWT.NONE);
		behavioralPatterns.setText("Modèles comportamentaux");

		TreeItem behavioralPatternCor = new TreeItem(behavioralPatterns, SWT.NONE);
		behavioralPatternCor.setText("Chaine de responsabilité");
		behavioralPatterns.setExpanded(true);

		TreeItem structuralPatterns = new TreeItem(menu, SWT.NONE);
		structuralPatterns.setText("Modèles structurels");

		/**
		 * A modifier pour l'extensibilité du programme
		 */
		menu.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				if (menu.getSelection()[0].getItems().length == 0) {
					btnGenerate.setEnabled(true);
					this.disposeChildren(containerBody);
					mediator.setSettingView(menu.getSelection()[0].getText(), containerBody); // call Mediator for
																								// change setting
				}else {
					btnGenerate.setEnabled(false);
					this.disposeChildren(containerBody);
				}

			}

			public void disposeChildren(Composite composite) {
				if (composite.getChildren().length > 0) {
					for (Control elem : composite.getChildren()) {
						elem.dispose();
					}
				}
			}
		});
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Tree getTree() {
		return menu;
	}

}
