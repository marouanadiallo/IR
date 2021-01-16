package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ContainerBodySettingForCOR<T> extends Composite {

	private Class<T> argument;
	private Class<T> typeDeRetour;
	Button btnGnrerUneChaine;
	boolean isDefaultSolution;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ContainerBodySettingForCOR(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Group grpChaineDeResponsabilit = new Group(this, SWT.NONE);
		grpChaineDeResponsabilit.setText("Chaine de responsabilit\u00E9");
		
		Group grpArguments = new Group(grpChaineDeResponsabilit, SWT.NONE);
		grpArguments.setText("Arguments");
		grpArguments.setBounds(10, 88, 386, 87);
		
		Button btnInteger = new Button(grpArguments, SWT.RADIO);
		btnInteger.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				setArgument((Class<T>)Integer.class);
			}
		});
		btnInteger.setBounds(10, 35, 81, 20);
		btnInteger.setText("Integer");
		
		Button btnDouble = new Button(grpArguments, SWT.RADIO);
		btnDouble.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				setArgument((Class<T>)Double.class);
			}
		});
		btnDouble.setBounds(97, 35, 81, 20);
		btnDouble.setText("Double");
		
		Button btnString = new Button(grpArguments, SWT.RADIO);
		btnString.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				setArgument((Class<T>)String.class);
			}
		});
		btnString.setBounds(184, 35, 73, 20);
		btnString.setText("String");
		
		Button btnObject = new Button(grpArguments, SWT.RADIO);
		btnObject.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				setArgument((Class<T>)Object.class);
			}
		});
		btnObject.setBounds(263, 35, 81, 20);
		btnObject.setText("Object");
		
		Group grpTypeDeRetour = new Group(grpChaineDeResponsabilit, SWT.NONE);
		grpTypeDeRetour.setText("Type de retour");
		grpTypeDeRetour.setBounds(10, 181, 386, 87);
		
		Button btnInteger_1 = new Button(grpTypeDeRetour, SWT.RADIO);
		btnInteger_1.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				setTypeDeRetour((Class<T>)Integer.class);
			}
		});
		btnInteger_1.setBounds(10, 36, 78, 20);
		btnInteger_1.setText("Integer");
		
		Button btnDouble_1 = new Button(grpTypeDeRetour, SWT.RADIO);
		btnDouble_1.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				setTypeDeRetour((Class<T>)Double.class);
			}
		});
		btnDouble_1.setBounds(94, 36, 78, 20);
		btnDouble_1.setText("Double");
		
		Button btnString_1 = new Button(grpTypeDeRetour, SWT.RADIO);
		btnString_1.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				setTypeDeRetour((Class<T>)String.class);
			}
		});
		btnString_1.setBounds(178, 36, 72, 20);
		btnString_1.setText("String");
		
		Button btnObject_1 = new Button(grpTypeDeRetour, SWT.RADIO);
		btnObject_1.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				setTypeDeRetour((Class<T>)Object.class);
			}
		});
		btnObject_1.setBounds(256, 36, 111, 20);
		btnObject_1.setText("Object");
		
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

	
	/**
	 * @return the argument
	 */
	public Class<T> getArgument() {
		return argument;
	}

	/**
	 * @param argument the argument to set
	 */
	public void setArgument(Class<T> argument) {
		this.argument = argument;
	}

	/**
	 * @return the typeDeRetour
	 */
	public Class<T> getTypeDeRetour() {
		return typeDeRetour;
	}

	/**
	 * @param typeDeRetour the typeDeRetour to set
	 */
	public void setTypeDeRetour(Class<T> typeDeRetour) {
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
