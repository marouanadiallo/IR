package model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public final class GenerateAbstractExpertCorWithDefaultSolution{

	public final static <U, T> void generateAbstractClassExpertCorWithDefaultSolution(String destinationPath,
			T paramType, U returnType) throws IOException {

		TypeSpec expertCor = TypeSpec.classBuilder("ExpertCor").addSuperinterface(ClassName.get("cor", "Expert"))
				.addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC)
				.addField(ClassName.get("cor", "ExpertCor"), "nextExpert")
				.addMethod(Generate.generateConstructorAbstractCassExpertCor("ExpertCor").build())
				.addMethod(generateImplementMethodSolveFromExpert(paramType, returnType).build())
				.addMethod(
						Generate.generateImplementMethodSovle("solve1", paramType, returnType, "handler", "solve1", false).build())
				.addMethod(Generate.generateMethodSolve("defaultSolution", paramType, returnType, false)
						.addStatement("return null")
						.build())
				.addMethod(Generate.generateMethodSolve("handler", paramType, returnType, true).build()).build();

		JavaFile javaFile = JavaFile.builder("cor", expertCor).build();

		Path path = Paths.get(destinationPath);
		javaFile.writeTo(path);
	}
	
	private static <T, U> MethodSpec.Builder generateImplementMethodSolveFromExpert(T paramType, U returnType)
	{
		MethodSpec.Builder solve = Generate.generateMethodSolve("solve", paramType, returnType, false);
		solve.addAnnotation(Override.class);
		solve.addStatement("$T result = this.$N($N)", returnType, "solve1", "param");
		solve.beginControlFlow("if ( result != null )");
		solve.addStatement("return $N", "result");
		solve.nextControlFlow("else");
		solve.addStatement("return $N($N)", "defaultSolution", "param");
		solve.endControlFlow();
		return solve; 
	}
}