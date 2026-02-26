# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class com.terista.space.core.** {*; }
-keep class com.terista.space.core.jnihook.** {*; }
-keep class mirror.** {*; }
-keep class android.** {*; }
-keep class com.android.** {*; }

-keep class com.terista.space.reflection.** {*; }
-keep @com.terista.space.reflection.annotation.BClass class * {*;}
-keep @com.terista.space.reflection.annotation.BClassName class * {*;}
-keep @com.terista.space.reflection.annotation.BClassNameNotProcess class * {*;}
-keepclasseswithmembernames class * {
    @com.terista.space.reflection.annotation.BField.* <methods>;
    @com.terista.space.reflection.annotation.BFieldNotProcess.* <methods>;
    @com.terista.space.reflection.annotation.BFieldSetNotProcess.* <methods>;
    @com.terista.space.reflection.annotation.BFieldCheckNotProcess.* <methods>;
    @com.terista.space.reflection.annotation.BMethod.* <methods>;
    @com.terista.space.reflection.annotation.BStaticField.* <methods>;
    @com.terista.space.reflection.annotation.BStaticMethod.* <methods>;
    @com.terista.space.reflection.annotation.BMethodCheckNotProcess.* <methods>;
    @com.terista.space.reflection.annotation.BConstructor.* <methods>;
    @com.terista.space.reflection.annotation.BConstructorNotProcess.* <methods>;
}