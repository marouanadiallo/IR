package controller;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.widgets.Composite;

import com.squareup.javapoet.ClassName;

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
			ClassName paramTypeClass;
			ClassName returnTypeClass;

			File fa = new File(cor.getClassArgument().getText());
			File fr = new File(cor.getClassRetour().getText());
			if (paramTypeSelected == null && returnTypesSelected == null) {
				paramTypeClass = ClassName.get(fa.getParentFile().getName(),
						fa.getName().substring(0, fa.getName().indexOf(".")));
				
				returnTypeClass = ClassName.get(fr.getParentFile().getName(),
						fr.getName().substring(0, fr.getName().indexOf(".")));

				this.generateCor(pathAbsoluteSrc, paramTypeClass, returnTypeClass, cor.withDefaultSolution());
			}else if(paramTypeSelected == null) {
				paramTypeClass = ClassName.get(fa.getParentFile().getName(),
						fa.getName().substring(0, fa.getName().indexOf(".")));
				this.generateCor(pathAbsoluteSrc, paramTypeClass, returnTypesSelected, cor.withDefaultSolution());
			}else if(returnTypesSelected == null){
				returnTypeClass = ClassName.get(fr.getParentFile().getName(),
						fr.getName().substring(0, fr.getName().indexOf(".")));
				this.generateCor(pathAbsoluteSrc, paramTypeSelected, returnTypesSelected, cor.withDefaultSolution());
			}else {
				this.generateCor(pathAbsoluteSrc, paramTypeSelected, returnTypesSelected, cor.withDefaultSolution());
			}
			return true;
		}
		return false;
	}

	private <T, U> void generateCor(String path, T param, U returnType, boolean whitDefaultSolution) {
		try {
			GenerateInterfaceExpert.generateInerfaceExpert(path,
					Generate.generateMethodSolve("solve", param, returnType, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (whitDefaultSolution) {
			try {
				GenerateAbstractExpertCorWithoutDefaultSolution
						.generateAbstractClassExpertCORWithoutDefaultSolution(path, param, returnType);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				GenerateAbstractExpertCorWithDefaultSolution.generateAbstractClassExpertCorWithDefaultSolution(path,
						param, returnType);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
