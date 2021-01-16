package controller;

import java.io.IOException;

import org.eclipse.swt.widgets.Composite;

import model.Generate;
import model.GenerateAbstractExpertCorWithDefaultSolution;
import model.GenerateAbstractExpertCorWithoutDefaultSolution;
import model.GenerateInterfaceExpert;
import view.ContainerBodySettingForCOR;

public class ControllerCor extends AbstractExpertController {

	public ControllerCor(AbstractExpertController next) {
		super(next);
	}

	@Override
	public boolean generateExpert(String typePattern, String pathAbsoluteSrc, Composite setting) {

		if (typePattern.equalsIgnoreCase("chaine de responsabilité")) {

			ContainerBodySettingForCOR<?> cor = (ContainerBodySettingForCOR<?>) setting;

			Class<?> paramTypeSelected = (Class<?>) cor.getArgument();
			Class<?> returnTypesSelected = (Class<?>) cor.getTypeDeRetour();

			try {
				GenerateInterfaceExpert.generateInerfaceExpert(pathAbsoluteSrc,
						Generate.generateMethodSolve("solve", paramTypeSelected, returnTypesSelected, true));
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (cor.withDefaultSolution()) {
				try {
					GenerateAbstractExpertCorWithoutDefaultSolution
							.generateAbstractClassExpertCORWithoutDefaultSolution(pathAbsoluteSrc, paramTypeSelected,
									returnTypesSelected);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					GenerateAbstractExpertCorWithDefaultSolution.generateAbstractClassExpertCorWithDefaultSolution(
							pathAbsoluteSrc, paramTypeSelected, returnTypesSelected);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return true;
		}
		return false;
	}

}
