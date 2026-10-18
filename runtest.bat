@echo off
mkdir bin 2>nul
javac -encoding UTF-8 -d bin src/main/java/com/filmnow/*.java
if errorlevel 1 exit /b 1
javac -encoding UTF-8 -cp "junit.jar;bin" -d bin src/test/java/com/filmnow/*.java
if errorlevel 1 exit /b 1
java -jar junit.jar --class-path bin --scan-class-path

