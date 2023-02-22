# SpringBoot Code Encrypt

# project Structure

## clazz

Contains CustomerClassLoader ``com.dimple.codeencrypt.clazz.classloader.CustomerClassLoader`` and encrypt class
generate ``com.dimple.codeencrypt.clazz.generator.ClassSourceGenerator`` method and check decrypt class file
method ``com.dimple.codeencrypt.clazz.classloader.LoadClass``.

## runtime

inject the encrypted class into springboot context.

## web

a simple springboot web app.

# Step for using this demo

1. Firstly, you should compile your project.
2. then, you should use ``com/dimple/codeencrypt/clazz/generator/ClassSourceGenerator.java`` generate encrypted
   class file, and you will get an encrypted class file in your project folder ``target/classes/META-INF/services``.
   Please make sure the class file in your project root path. certainly, you can change the logic if you
   want change it.
2. then you can check the encryed class file if can be decrypted by
   using ``com.dimple.codeencrypt.clazz.classloader.LoadClass``.
3. then run the springboot application. you can see the application running abnormal.

# Next Step

you can write your customer maven plugin to make automatic code generation.
