# What is the UX Library?

The UX Library is a set of styled components that have been designed specifically for app development on RealWear devices. The components are based on common Android components and adhere to Android standard practices, while also providing additional functionality to address the most common challenges encountered when developing for RealWear devices, namely speech enablement, head tracking, and theming.

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
  implementation 'com.realwear:UXLibrary:v1.5.0.493'
}
```

**Note:** if you are using Java instead of Kotlin, you will also need to import RecyclerView implementation if you want to use the Horizontal Selector component.

```
dependencies {
  ...
  implementation 'com.realwear:UXLibrary:v1.5.0.493'
  implementation 'androidx.recyclerview:recyclerview:1.1.0'
}
```

# UX Library Components

The RealWear UX Library comprises of 8 main components:

* Toggle Button
* Command Button
* Styled Text View
* Level Control
* Horizontal Selector
  - Fragment
  - Activity
* More Options
* Radio Group
* Command Bar

# More information

For more information on the UX Level, and instructions on how to use it please see the [wiki](https://github.com/realwear/UXLibrary-Example/wiki/).