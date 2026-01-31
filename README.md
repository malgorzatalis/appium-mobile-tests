# Appium Mobile Test
Automated UI tests for native mobile applications built with Appium and Java.
This project currently focuses on Android application testing and is intended as a portfolio project for Mobile QA automation. 
The framework is structured to allow future extension to iOS if requried. 

## Tech stack
-Java 21  
-Appium  
-TestNG  
-Maven  

## Project structure
-driver (driver creation and configuration)  
-config (JSON default configuration)  
-pages (POM)  
-tests (test scearios)  
-testdata (JSON external test data)

## Prerequisites
-Appium server installed and running  
-Android emulator or real device    

```bash
appium driver install uiautomator2   
```

## Running tests  
Tests require providing the APK path via a JVM parameter. You can download APK here -> https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk  
### Required parameter:   
```bash
mvn test -DappPath=/path/to/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk
```

### Optonal overrides  
```bash
-DserverUrl  
-DplatformName  
-DdeviceName  
-DnoReset
```
  
### Example command  
```bash
mvn test \
  -DappPath=/path/to/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk \
  -DdeviceName="Pixel_8" \
  -DnoReset=true
```


