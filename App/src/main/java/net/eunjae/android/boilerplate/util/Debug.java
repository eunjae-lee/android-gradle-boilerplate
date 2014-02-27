package net.eunjae.android.boilerplate.util;

import android.util.Log;

import net.eunjae.android.boilerplate.BuildConfig;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Debug {
    public static boolean isDebugMode() {
        return !BuildConfig.buildType.isRelease();
    }

    public static void i(String format, Object... args) {
        if (isDebugMode()) {
            try {
                Log.i(getClassName(), String.format(format, args));
            } catch (Exception e) {
                Log.d("Debug", "An exception occured during printing logs : " + e.toString());
            } catch (Error e) {
                Log.d("Debug", "An error occured during printing logs : " + e.toString());
            }
        }
    }

    public static void d(String format, Object... args) {
        if (isDebugMode()) {
            try {
                Log.d(getClassName(), String.format(format, args));
            } catch (Exception e) {
                Log.d("Debug", "An exception occured during printing logs : " + e.toString());
            } catch (Error e) {
                Log.d("Debug", "An error occured during printing logs : " + e.toString());
            }
        }
    }

    public static void e(String format, Object... args) {
        if (isDebugMode()) {
            try {
                Log.e(getClassName(), String.format(format, args));
            } catch (Exception e) {
                Log.d("Debug", "An exception occured during printing logs : " + e.toString());
            } catch (Error e) {
                Log.d("Debug", "An error occured during printing logs : " + e.toString());
            }
        }
    }

    public static void logHeap(Class clazz, String tag) {
        Double allocated = new Double(android.os.Debug.getNativeHeapAllocatedSize()) / new Double((1048576));
        Double available = new Double(android.os.Debug.getNativeHeapSize()) / 1048576.0d;
        Double free = new Double(android.os.Debug.getNativeHeapFreeSize()) / 1048576.0d;

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        Log.d(tag, "debug. =================================");
        Log.d(tag, "debug.heap native: allocated " + df.format(allocated) + "MB of " + df.format(available) + "MB ("
                + df.format(free) + "MB free) in [" + clazz.getName().replaceAll("com.myapp.android.", "") + "]");
        Log.d(tag,
                "debug.memory: allocated: " + df.format(new Double(Runtime.getRuntime().totalMemory() / 1048576))
                        + "MB of " + df.format(new Double(Runtime.getRuntime().maxMemory() / 1048576)) + "MB ("
                        + df.format(new Double(Runtime.getRuntime().freeMemory() / 1048576)) + "MB free)");
    }

    private static String toString(StackTraceElement elem) {
        String prefix = "    ";
        String classFullName = elem.getClassName();
        String className = classFullName.substring(classFullName.lastIndexOf(".") + 1);
        String methodName = elem.getMethodName();

        return String.format("%s%s::%s (%d)", prefix, className, methodName, elem.getLineNumber());
    }

    public static void dump() {
        if (isDebugMode() == false)
            return;

        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement previous = e.getStackTrace()[2];
            String prevClassFullName = previous.getClassName();
            String prevClassName = prevClassFullName.substring(prevClassFullName.lastIndexOf(".") + 1);

            for (int i = 0; i < 30; i++) {
                if (e.getStackTrace().length <= i)
                    break;
                Log.d(prevClassName, toString(e.getStackTrace()[i]));
            }
        }
    }

    public static String getClassName() {
        String className = "";
        // String methodName = "";
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement previous = e.getStackTrace()[2];
            String classFullName = previous.getClassName();
            className = classFullName.substring(classFullName.lastIndexOf(".") + 1);
            // methodName = previous.getMethodName();
        }
        // Log.d("Debug", String.format("className is %s", className));
        int dolor = className.indexOf("$");
        if (dolor != -1) {
            className = className.substring(0, dolor);
        }
        // Log.d("Debug", String.format("className is %s", className));
        return className;
    }

    public static String getCaller(int before) {
        String className = "";
        String methodName = "";
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement previous = e.getStackTrace()[2 + before];
            String classFullName = previous.getClassName();
            className = classFullName.substring(classFullName.lastIndexOf(".") + 1);
            methodName = previous.getMethodName();
        }
        // Log.d("Debug", String.format("className is %s", className));
        int dolor = className.indexOf("$");
        if (dolor != -1) {
            className = className.substring(0, dolor);
        }
        // Log.d("Debug", String.format("className is %s", className));
        return String.format("%s::%s", className, methodName);
    }

    public static String getCaller() {
        return getCaller(0);
    }

    public static void array(String name, ArrayList array) {
        if (isDebugMode()) {
            String result = "";
            for (Object item : array) {
                result += item.toString() + ", ";
            }

            Log.d(getClassName(), name + "] " + result);
        }
    }
}
