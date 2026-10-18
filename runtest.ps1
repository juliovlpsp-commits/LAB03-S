mkdir bin -Force | Out-Null
javac -encoding UTF-8 -d bin src/main/java/com/filmnow/*.java
if ($LASTEXITCODE -ne 0) { exit 1 }
javac -encoding UTF-8 -cp "junit.jar;bin" -d bin src/test/java/com/filmnow/*.java
if ($LASTEXITCODE -ne 0) { exit 1 }
java -jar junit.jar --class-path bin --scan-class-path

