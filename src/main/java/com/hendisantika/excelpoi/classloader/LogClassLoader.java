package com.hendisantika.excelpoi.classloader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created by liuyan on 2019/1/17.
 */
public class LogClassLoader extends ClassLoader {
// aClass.getField("ex").set(null, "execution(public * com.hendisantika.excelpoi.controller..*(..))");

    public LogClassLoader() {
        super(ClassLoader.getSystemClassLoader());
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("com.hendisantika.excelpoi.aop.LogAdapter")) { //防止委派加载这个类
            return findClass(name);
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        BufferedInputStream bis = null;
        try {
            //加载类路径下的类
            URL url = ClassLoader.getSystemClassLoader().getResource("");
            String path = url.getPath();
            if (path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }
            String packagePath = name.replaceAll("\\.", "/");
            path = path + "/" + packagePath + ".class";
            bis = new BufferedInputStream(new FileInputStream(path));
            byte[] data = new byte[bis.available()];
            bis.read(data);
            Class<?> aClass = defineClass(name, data, 0, data.length);
            aClass.getField("aaa").set(null, "execution(public * com.hendisantika.excelpoi.controller..*(..))");
            aClass.getField("sss").set("sss", "execution(public * com.hendisantika.excelpoi.controller..*(..))");
            return aClass;
        } catch (Exception e) {
            e.printStackTrace();
            return super.findClass(name);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
