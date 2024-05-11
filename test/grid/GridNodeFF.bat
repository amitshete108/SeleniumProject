c:
cd "C:\Selenium\Training Workspace\Selenium Training\lib"
java ^
-Dwebdriver.gecko.driver="C:\Selenium\Training Workspace\Selenium Training\lib\geckodriver64bit.exe" ^
-jar selenium-server-standalone-3.13.0.jar -role node ^
-hub http://192.168.0.104:4444/grid/register ^
-browser "browserName=firefox,maxInstances=3" ^
-maxSession 3
pause