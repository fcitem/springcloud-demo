@echo off

cd %~dp0
cd..
echo ��ʼ���
call mvn compile package
echo.
echo ��ʼ���ز���

call mvn install
echo ��ʼdocker����
call mvn docker:build
echo.
echo docker������ɣ�
pause