package FrameworkJavaFx;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JFrame;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import javafx.scene.control.RadioButton;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.IntegerMemberValue;

public class Executor extends JFrame {

public Executor(HashMap<String, String> chosen) throws NotFoundException, IOException, CannotCompileException {
	Iterator<Entry<String, String>> it = chosen.entrySet().iterator();
	while(it.hasNext()) {
		Entry<String, String> m=it.next();
		String key=m.getKey();
		String value=m.getValue();
		System.out.println(key+"    la clés est choisie pour la valeur suivante          "+value+"la taille "+chosen.size());
		generateAssets(key,value);

		
	}
	
}

public void generateAssets(String key, String value) throws NotFoundException, IOException, CannotCompileException {
	// TODO Auto-generated method stub
	if(value=="Aspect programming") {
		 ClassWriter cw = new ClassWriter(0);
	        cw.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER,
	          key, null, "java/lang/Object", null);
	        cw.visitAnnotation("@Retention(RUNTIME) ", true);
	        cw.visitAnnotation("@Aspect ", true).visitEnd();
	 
	        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "doSomething", "()V", null, null);
	        
	        mv.visitCode();
	        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	        mv.visitLdcInsn("pointcut here!");
	        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
	        mv.visitInsn(Opcodes.RETURN);
	        mv.visitMaxs(0, 0);
	        mv.visitAnnotation("@pouintcut(\"execution(* Operation.*(..))\") ", true);
	        MethodVisitor mv2 = cw.visitMethod(Opcodes.ACC_PUBLIC, "adviceCode", "()V", null, null);
	        mv2.visitCode();
	        mv2.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	        mv2.visitLdcInsn("advice here!");
	        mv2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
	        mv2.visitInsn(Opcodes.RETURN);
	        mv2.visitMaxs(0, 0);
	        mv2.visitAnnotation("@After(\"doSomething()\") ", true);
	        cw.visitEnd();
	        byte[] bytes = cw.toByteArray();
	        String url="C:/Users/belarbim/WeatherForecastEclipse/framework-rules/src/main/java/GeneratedFiles/".concat(key).concat(".class");
	        FileOutputStream out=new FileOutputStream(url);
			out.write(cw.toByteArray());
			out.close();
		/* Class<?> klass = new ClassLoader(Executor.class.getClassLoader()) {
		      public Class<?> defineClass(String key) throws IOException {
		       
		        
		      }
		    }.defineClass( key);*/

		    
		  
	}
	if(value=="Conditional-Compilation") {
		        ClassWriter cw = new ClassWriter(0);
		        cw.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER,
		          key, null, "java/lang/Object", null);
		        cw.visitEnd();
		        byte[] bytes = cw.toByteArray();
		        String url="C:/Users/belarbim/WeatherForecastEclipse/framework-rules/src/main/java/GeneratedFiles/".concat(key).concat(".class");
		        FileOutputStream out=new FileOutputStream(url);
				out.write(cw.toByteArray());
				out.close();
		        
		      
	}
	if(value=="install with JDBC") {
		DbGenerator g=new DbGenerator();
		g.Connexion();
	}
}
}
