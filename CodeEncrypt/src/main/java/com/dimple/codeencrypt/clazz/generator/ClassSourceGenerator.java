package com.dimple.codeencrypt.clazz.generator;

import com.dimple.codeencrypt.clazz.constant.CommonConstants;
import com.dimple.codeencrypt.clazz.utils.EnCryptUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassSourceGenerate
 *
 * @author BianXiaofeng
 * @date 2022/11/17 10:35
 */
@Slf4j
public class ClassSourceGenerator {


    /**
     * Generate encrypt class.
     * put encrypted class file in origin path
     *
     * @param args
     */
    public static void main(String[] args) {
        for (String classReference : CommonConstants.NEED_ENCRYPT_CLASS_REFERENCE) {
            String clasFileSrcPath = getClassFileSrcPath(classReference);
            ///D:/Personal/SpringBootDemos/CodeEncrypt/target/classes/META-INF/services/
            String classFileDestDir = ClassSourceGenerator.class.getClassLoader().getResource("").getPath() + "/" + CommonConstants.ENCRYPT_CLASS_ROOT_DIR;
            String classFieldDestPath = classFileDestDir + classReference + CommonConstants.ENCRYPTED_CLASS_SUFFIX;
            EnCryptUtils.encrypt(clasFileSrcPath, classFieldDestPath);
        }
    }

    /**
     * get current class path
     *
     * @param classReference class path like <code>com.dimple.codeencrypt.web.service.impl.UserServiceImpl</code>
     * @return the real path,eg : D:/Personal/SpringBootDemos/CodeEncrypt/UserServiceImpl.class
     */
    private static String getClassFileSrcPath(String classReference) {
        // basePath : /D:/Personal/SpringBootDemos/CodeEncrypt/target/classes/com/dimple/codeencrypt/clazz/generator/
        String basePath = ClassSourceGenerator.class.getResource("").getPath();
        // projectPath : /D:/Personal/SpringBootDemos/CodeEncrypt/
        String projectPath = basePath.substring(0, basePath.indexOf("target"));
        String[] split = classReference.split("\\.");
        String classFileName = split[split.length - 1];
        return projectPath + classFileName + ".class";
    }

}
