#!/bin/sh
source ~/.bash_profile
pid_file='pid.pid'
start()
{
        echo $"Starting logistics application server ......"
        java -server -Xms512m -Xmx512m  -jar logistics.jar > output 2>&1 &
        echo $! > $pid_file

        echo $"logistics application server started!"
}

stop()
{
        echo $"Stopping logistics application server ......"
        pid=`cat $pid_file`
        kill -9 $pid
        echo "stop "$pid
        sleep 1
}

restart()
{
        stop
        sleep 5
        start
}

case "$1" in
start)
        start
        ;;
stop)
        stop
        ;;
restart)
        restart
        ;;
*)
        echo $"Usage: $0 {start|stop|restart}"
        exit 1
esac
