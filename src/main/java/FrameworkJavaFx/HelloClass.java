package FrameworkJavaFx;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import javassist.util.proxy.DefineClassHelper;

import static org.objectweb.asm.Opcodes.*;
public class HelloClass {
	public static void main(String[] args) throws Exception {
		
		      ClassWriter cw = new ClassWriter(0);
			        cw.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER,
			          "MyAspect", null, "java/lang/Object", null);
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
			        String url="C:/Users/belarbim/WeatherForecastEclipse/framework-rules/src/main/java/GeneratedFiles/MyAspect.class";
			        FileOutputStream out=new FileOutputStream(url);
					out.write(cw.toByteArray());
					out.close();
			        
			

		   
		   
	/*	 for (Field f : klass.getDeclaredFields()) {
		      System.out.println(f + " " + Arrays.toString(f.getAnnotations()));
		    }
	 * ClassWriter cw=new ClassWriter(0);
		
		cw.visit(V1_6, ACC_PUBLIC+ACC_SUPER, "sample/HelloGen", null, "java/lang/Object", null);
	
		//default constructor
		{
			MethodVisitor mv=cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0); //load the first local variable: this
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(1,1);
			mv.visitEnd();
		}
		
		//main method
		{
			MethodVisitor mv=cw.visitMethod(ACC_PUBLIC+ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC,"java/lang/System", "out", "Ljava/io/PrintStream;"); //put System.out to operand stack
			mv.visitLdcInsn("Hello"); //load const "Hello" from const_pool, and put onto the operand stack
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(2,1);
			mv.visitEnd();
		}
		cw.visitEnd();
		
		//save bytecode into disk
		FileOutputStream out=new FileOutputStream("C:/Users/belarbim/WeatherForecastEclipse/MyPizza/src/TestCode/Files/HelloGen.class");
		out.write(cw.toByteArray());
		out.close();
	*/}


}
