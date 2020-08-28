# What is the UX Library?

The UX Library is a set of styled components that have been designed specifically for app development on the HMT-1 and HMT-1Z1 platforms. The components are based on common Android components and adhere to Android standard practices, while also providing additional functionality to address the most common challenges encountered when developing for RealWear devices, namely speech enablement, head tracking, and theming.

This repository contains examples on how to use each component of the UX Library.

# Usage

To use the UX Library in your Android project, you need to import it using Gradle.

First add the JitPack repository to your root build.gradle at the end of the repositories section:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Then add the UX Library dependency to your application build.gradle.

```
dependencies {
  ...
  implementation 'com.realwear:UXLibrary:v1.0.0.122'
}
```

**Note:** if you are using Java instead of Kotlin, you will also need to import RecyclerView implementation if you want to use the Horizontal Selector component.

```
dependencies {
  ...
  implementation 'com.realwear:UXLibrary:v1.0.0.122'
  implementation 'androidx.recyclerview:recyclerview:1.1.0'
}
```

# UX Library Components

The RealWear UX Library comprises of 6 main components:

* [[Command Button|command-button]]
* [[Styled Text View|Styled-Text-View]]
* [[Level Control|Level-Control]]
* [[Horizontal Selector|Horizontal-Selector]]
* [[More Options|More-Options]]
* [[Radio Group|Radio-Group]]

# More information

For more information on the UX Level, and instructions on how to use it please see the [wiki](https://github.com/realwear/UXLibrary-Example/wiki/).