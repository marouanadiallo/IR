package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ContainerBodySettingForCOR<T> extends Composite {

	private Class<?> argument ;
	private Class<?> typeDeRetour;
	Button btnGnrerUneChaine;
	Button btnSelectArgument;
	Button btnSelectRetour;
	boolean isDefaultSolution;
	Text classArgument;
	Text classRetour;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	@SuppressWarnings("unchecked")
	public ContainerBodySettingForCOR(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Group grpChaineDeResponsabilit = new Group(this, SWT.NONE);
		grpChaineDeResponsabilit.setText("Chaine de responsabilit\u00E9");
		
		Group grpArguments = new Group(grpChaineDeResponsabilit, SWT.NONE);
		grpArguments.setText("Arguments");
		grpArguments.setBounds(10, 88, 386, 150);
		
		
		
		Button btnInteger = new Button(grpArguments, SWT.RADIO);
		btnInteger.setSelection(true);
		setArgument((Class<T>)Integer.class);
		btnSelectArgument = btnInteger;
		
		btnInteger.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setArgument((Class<T>)Integer.class);
				btnSelectArgument = btnInteger;
			}
		});
		btnInteger.setBounds(10, 35, 81, 20);
		btnInteger.setText("Integer");
		
		Button btnDouble = new Button(grpArguments, SWT.RADIO);
		btnDouble.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setArgument((Class<T>)Double.class);
				btnSelectArgument = btnDouble;
			}
		});
		btnDouble.setBounds(97, 35, 81, 20);
		btnDouble.setText("Double");
		
		Button btnString = new Button(grpArguments, SWT.RADIO);
		btnString.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setArgument((Class<T>)String.class);
				btnSelectArgument = btnString;
			}
		});
		btnString.setBounds(184, 35, 73, 20);
		btnString.setText("String");
		
		Button btnObject = new Button(grpArguments, SWT.RADIO);
		btnObject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setArgument((Class<T>)Object.class);
				btnSelectArgument = btnObject;
			}
		});
		btnObject.setBounds(263, 35, 81, 20);
		btnObject.setText("Object");
		
		Label lblClassArgument = new Label(grpArguments, SWT.CENTER);
		lblClassArgument.setBounds(10, 90, 50, 30);
		lblClassArgument.setAlignment(SWT.CENTER);
		lblClassArgument.setText("Class : ");
		
		classArgument = new Text(grpArguments, SWT.BORDER | SWT.READ_ONLY);
		classArgument.setBounds(60, 85, 220, 30);
		
		Button btnOuvrirClassArgument = new Button(grpArguments, SWT.NONE);
		btnOuvrirClassArgument.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ContainerBodySettingForCOR.this.btnSelectArgument.setSelection(false);
				ContainerBodySettingForCOR.this.setArgument(null);
				if(!choiceClass(classArgument)) {
					btnInteger.setSelection(true);
					setArgument((Class<T>)Integer.class);
					btnSelectArgument = btnInteger;
				}
			}
		});
		
		btnOuvrirClassArgument.setBounds(285, 85, 90, 30);
		btnOuvrirClassArgument.setText("ouvrir...");
		
		
		Group grpTypeDeRetour = new Group(grpChaineDeResponsabilit, SWT.NONE);
		grpTypeDeRetour.setText("Type de retour");
		grpTypeDeRetour.setBounds(10, 250, 386, 150);
		
		Button btnInteger_1 = new Button(grpTypeDeRetour, SWT.RADIO);
		btnInteger_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setTypeDeRetour((Class<T>)Integer.class);
				btnSelectRetour = btnInteger_1;
			}
		});
		btnInteger_1.setBounds(10, 36, 78, 20);
		btnInteger_1.setText("Integer");
		
		Button btnDouble_1 = new Button(grpTypeDeRetour, SWT.RADIO);
		btnDouble_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setTypeDeRetour((Class<T>)Double.class);
				btnSelectRetour = btnDouble_1;
			}
		});
		btnDouble_1.setBounds(94, 36, 78, 20);
		btnDouble_1.setText("Double");
		
		Button btnString_1 = new Button(grpTypeDeRetour, SWT.RADIO);
		btnString_1.setSelection(true);
		setTypeDeRetour((Class<T>)String.class);
		btnSelectRetour = btnString_1;
		
		btnString_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setTypeDeRetour((Class<T>)String.class);
				btnSelectRetour = btnString_1;
			}
		});
		btnString_1.setBounds(178, 36, 72, 20);
		btnString_1.setText("String");
		
		Button btnObject_1 = new Button(grpTypeDeRetour, SWT.RADIO);
		btnObject_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setTypeDeRetour((Class<T>)Object.class);
				btnSelectRetour = btnObject_1;
			}
		});
		btnObject_1.setBounds(256, 36, 111, 20);
		btnObject_1.setText("Object");
		
		Label lblClassRetour = new Label(grpTypeDeRetour, SWT.CENTER);
		lblClassRetour.setBounds(10, 90, 50, 30);
		lblClassRetour.setAlignment(SWT.CENTER);
		lblClassRetour.setText("Class : ");
		
		classRetour = new Text(grpTypeDeRetour, SWT.BORDER | SWT.READ_ONLY);
		classRetour.setBounds(60, 85, 220, 30);
		
		Button btnOuvrirClassRetour = new Button(grpTypeDeRetour, SWT.NONE);
		btnOuvrirClassRetour.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ContainerBodySettingForCOR.this.btnSelectRetour.setSelection(false);
				ContainerBodySettingForCOR.this.setTypeDeRetour(null);
				if(!choiceClass(classRetour)){
					btnString_1.setSelection(true);
					setTypeDeRetour((Class<T>)String.class);
					btnSelectRetour = btnString_1;
				}
			}
		});
		btnOuvrirClassRetour.setBounds(285, 85, 90, 30);
		btnOuvrirClassRetour.setText("ouvrir...");
		
		btnGnrerUneChaine = new Button(grpChaineDeResponsabilit, SWT.CHECK);
		btnGnrerUneChaine.setSelection(true);
		
		btnGnrerUneChaine.setBounds(10, 49, 386, 33);
		btnGnrerUneChaine.setText("Sans solution par d\u00E9faut");
		
		Label lblGnrerUneChaine = new Label(grpChaineDeResponsabilit, SWT.NONE);
		lblGnrerUneChaine.setBounds(10, 25, 386, 20);
		lblGnrerUneChaine.setText("G\u00E9n\u00E9rer une chaine de responsabilit\u00E9.");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private boolean choiceClass(Text input) {
		FileDialog dialog = new FileDialog(this.getShell(), SWT.OPEN | SWT.SHEET);
		dialog.setFilterExtensions(new String[] { "*.java"});
		
		String selectedFileName = dialog.open();
		
		if (selectedFileName != null) {
			input.setText(selectedFileName);
			return true;
		}else {
			System.out.println("annuler");
			return false;
		}
		
	}
	/**
	 * @return the classArgument
	 */
	public Text getClassArgument() {
		return classArgument;
	}

	/**
	 * @param classArgument the classArgument to set
	 */
	public void setClassArgument(Text classArgument) {
		this.classArgument = classArgument;
	}

	/**
	 * @return the classRetour
	 */
	public Text getClassRetour() {
		return classRetour;
	}

	/**
	 * @param classRetour the classRetour to set
	 */
	public void setClassRetour(Text classRetour) {
		this.classRetour = classRetour;
	}

	/**
	 * @return the btnSelectArgument
	 */
	public Button getBtnSelectArgument() {
		return btnSelectArgument;
	}

	/**
	 * @return the btnSelectRetour
	 */
	public Button getBtnSelectRetour() {
		return btnSelectRetour;
	}

	/**
	 * @return the argument
	 */
	public Class<?> getArgument() {
		return argument;
	}

	/**
	 * @param argument the argument to set
	 */
	public void setArgument(Class<?> argument) {
		this.argument = argument;
	}

	/**
	 * @return the typeDeRetour
	 */
	public Class<?> getTypeDeRetour() {
		return typeDeRetour;
	}

	/**
	 * @param typeDeRetour the typeDeRetour to set
	 */
	public void setTypeDeRetour(Class<?> typeDeRetour) {
		this.typeDeRetour = typeDeRetour;
	}

	/**
	 * @return the btnGnrerUneChaine
	 */
	public Button getBtnGnrerUneChaine() {
		return btnGnrerUneChaine;
	}
	public boolean withDefaultSolution()
	{
		return this.btnGnrerUneChaine.getSelection();
	}
	
}
