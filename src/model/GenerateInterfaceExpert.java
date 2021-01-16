package model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public final class GenerateInterfaceExpert {
	
	public final static void generateInerfaceExpert(String destinationPath, 
			MethodSpec.Builder methodSolve) throws IOException 
	{
		TypeSpec expert = TypeSpec
				.interfaceBuilder("Expert")
				.addModifiers(Modifier.PUBLIC)
				.addMethod(methodSolve.build())	
				.build();
		
		JavaFile javaFile = JavaFile
				  .builder("cor", expert)
				  .build();

				Path path = Paths.get(destinationPath);
				javaFile.writeTo(path);
	}
	
	
}
