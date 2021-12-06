::CONSTANTS
SET WORKING_DIR=D:\my_projects\BookStore\
SET LOG_DIR=D:\my_projects\BookStore\logs\
SET LOG_FILE_NAME=BookStore_tomcat_run_%DATE:~-4%%DATE:~3,2%%DATE:~0,2%.log
SET LOG_FILE=%LOG_DIR%%LOG_FILE_NAME%

echo WORKING_DIR : %WORKING_DIR%
echo LOG_DIR : %LOG_DIR%
echo LOG_FILE_NAME : %LOG_FILE_NAME%
echo LOG_FILE : %LOG_FILE%

cd %WORKING_DIR%
mvn spring-boot:run > %LOG_FILE% 2>&1
exit 0
