package com.kyang.mybatis.io;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @Author：wqy
 * @Description：
 * @create：2025-03-02
 */

public class Resources {

    public static Reader getResourceAsReader(String resource) {
        return new InputStreamReader(getResourceAsStream(resource));
    }

    private static InputStream getResourceAsStream(String resource) {
        ClassLoader[] classLoaders = getClassLoaders();

        for (ClassLoader classLoader : classLoaders) {
            InputStream inputStream = classLoader.getResourceAsStream(resource);

            if (inputStream!= null) {
                return inputStream;
            }
        }


        throw new RuntimeException("Could not find resource: " + resource);
    }

    private static ClassLoader[] getClassLoaders() {
        return new ClassLoader[] {
                ClassLoader.getSystemClassLoader(),
                Thread.currentThread().getContextClassLoader()
        };
    }

    public static Class<?> classForName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }
}
