c:
cd "C:\Selenium\Training Workspace\Selenium Training\lib"
java ^
-Dwebdriver.ie.driver="C:\Selenium\Training Workspace\Selenium Training\lib\ieDriverServer.exe" ^
-jar selenium-server-standalone-3.13.0.jar -role node ^
-hub http://192.168.0.104:4444/grid/register ^
-browser "browserName=internet explorer,maxInstances=3" ^
-maxSession 4
pause