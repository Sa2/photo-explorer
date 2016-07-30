
PROCESS_ID=`cat /apps/photo-explorer/photo-explorer-app-1.0-SNAPSHOT/RUNNING_PID`
echo "PID is $PROCESS_ID"
kill -2 $PROCESS_ID
rm -rf /apps/photo-explorer/photo-explorer-app-1.0-SNAPSHOT/RUNNING_PID
