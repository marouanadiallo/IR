package model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;


public final class GenerateAbstractExpertCorWithoutDefaultSolution {
		
	
	public final static <U, T> void generateAbstractClassExpertCORWithoutDefaultSolution(String destinationPath,
							Class<T> paramType, Class<U> returnType) throws IOException
	{
		
		TypeSpec expertCor = TypeSpec
				  .classBuilder("ExpertCor")
				  .addSuperinterface(ClassName.get("cor", "Expert"))
				  .addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC)
				  .addField(ClassName.get("cor", "ExpertCor"), "nextExpert")
				  .addMethod(Generate.generateConstructorAbstractCassExpertCor("ExpertCor").build())
				  .addMethod(Generate.generateImplementMethodSovle("solve",paramType, returnType,
						  "handler", "solve", true).build())
				  .addMethod(Generate.generateMethodSolve("handler", paramType, returnType, true).build())
				  .build();
				  
		
		JavaFile javaFile = JavaFile
				  .builder("cor", expertCor)
				  .build();

				Path path = Paths.get(destinationPath);
				javaFile.writeTo(path);
	}
	
}
