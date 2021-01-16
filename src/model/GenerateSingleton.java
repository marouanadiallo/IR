package model;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class GenerateSingleton {
	
	public static void generateSingleton(String destinationPath) throws IOException
	{
		TypeSpec singleton = TypeSpec
				  .classBuilder("Singleton")
				  .addSuperinterface(Serializable.class)
				  .addField(generateUniqueInstance())
				  .addMethod(MethodSpec.constructorBuilder()
						  .addModifiers(Modifier.PRIVATE)
						  .addJavadoc("private constructor.")
						  .build())
				  .addMethod(generateGetInstance())
				  .addMethod(MethodSpec.methodBuilder("readResolve")
						  .returns(Object.class)
						  .addModifiers(Modifier.PRIVATE)
						  .addStatement("return $N", "INSTANCE")
						  .addJavadoc("Anti-deserialization security.")
						  .build())
				  .build();
		
		JavaFile javaFile = JavaFile
				  .builder("singleton", singleton)
				  .build();

				Path path = Paths.get(destinationPath);
				javaFile.writeTo(path);
				  
	}
	
	private static FieldSpec generateUniqueInstance () {
		return FieldSpec.builder(ClassName.get("singleton", "Singleton"), "INSTANCE")
				.addModifiers(Modifier.PRIVATE, Modifier.STATIC)
				.initializer("new Singleton()")
				.addJavadoc("Single instance pre-initialized.")
				.build();
	}
	
	private static MethodSpec generateGetInstance()
	{
		return MethodSpec.methodBuilder("getInstance")
				.returns(ClassName.get("singleton", "Singleton"))
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.addStatement("return $N ", "INSTANCE")
				.addJavadoc("Access point for the single instance of the singleton.")
				.build();
	}
}
