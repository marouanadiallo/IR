package gncor.gnsingleton.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import view.Win;

public class GenerateDesignPattern extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		/**
		 * Launch the application.
		 * @param args
		 */
			try {
				Win window = new Win();
				window.open();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
}
