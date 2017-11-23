@echo off

cd %~dp0
cd..
echo 开始打包
call mvn compile package
echo.
echo 开始本地部署

call mvn install
echo 开始docker发布
call mvn docker:build
echo.
echo docker部署完成！
pause