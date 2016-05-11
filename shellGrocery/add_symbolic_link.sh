#!/bin/bash
USAGE="This shell script is used to create a soft link in
	/usr/bin for TARGET.\nusage: sudo $0 TARGET"
# [] which is equal to *test* is used to simple judgement.
if [[ "$1" = "--help" || "$1" = "-h" || "$1" = "" ]];then
	echo -e ${USAGE}
	exit
fi

TARGET=$(pwd)/$1
LINK_NAME=/usr/bin/$1

if [ -e ${LINK_NAME} ];then	# -L: symbol link
	echo "${LINK_NAME} is exist!"
	exit
else
	ln -s ${TARGET} ${LINK_NAME}
fi 
