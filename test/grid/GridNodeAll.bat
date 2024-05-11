c:
cd "C:\Users\ketan\OneDrive\Selenium\4.8\webdrivertrainingJan23\lib"
java ^
-jar selenium-server-4.8.0.jar node ^
-p 5564
-browser "browserName=firefox,maxInstances=10,platform=Windows" ^
-browser "browserName=chrome,maxInstances=15" ^
-browser "browserName=internet explorer,maxInstances=15" ^
-browser "browserName=safari,maxInstances=10" ^
-maxSession 20
pause