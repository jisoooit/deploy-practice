#!/usr/bin/env bash

PROJECT_NAME="deploy-practice"
PROJECT_ROOT=/home/ubuntu/$PROJECT_NAME

APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)


echo "> 현재 구동 중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -f $PROJECT_NAME)

echo "현재 구동 중인 애플리케이션 pid: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
  echo "$TIME_NOW > 현재 실행중인 애플리케이션이 없습니다" >> $DEPLOY_LOG
else
  echo "$TIME_NOW > 실행중인 $CURRENT_PID 애플리케이션 종료 " >> $DEPLOY_LOG
  kill -15 $CURRENT_PID
  sleep 5
fi

cp $PROJECT_ROOT/build/libs/*.jar $PROJECT_ROOT/

JAR_NAME=$(ls $PROJECT_ROOT | grep $PROJECT_NAME | tail -n 1)


echo "> $JAR_NAME 에 실행권한 추가"
chmod u+x $JAR_NAME

# jar 파일 실행
echo "$TIME_NOW > $JAR_NAME 파일 실행" >> $DEPLOY_LOG
nohup java -jar $PROJECT_ROOT/$JAR_NAME > $APP_LOG 2> $ERROR_LOG &

CURRENT_PID=$(pgrep -f $JAR_NAME)
echo "$TIME_NOW > 실행된 프로세스 아이디 $CURRENT_PID 입니다." >> $DEPLOY_LOG