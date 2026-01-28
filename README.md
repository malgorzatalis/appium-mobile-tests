# Appium Mobile Test
Automated UI tests for native mobile applications built with Appium and Java.
This project currently focuses on Android application testing and is intended as a portfolio project for Mobile QA automation. 
The framework is structured to allow future extension to iOS if requried. 

## Tech stack
-Java 21  
-Appium  
-TestNG  
-Maven  

## Prerequisites
-Appium server installed and running  
-Android emulator or real device    

## Running tests
Tests require providing the APK path via a JVM parameter. You can download APK here -> https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk 

```bash
mvn test -DappPath=/path/to/app.apk
