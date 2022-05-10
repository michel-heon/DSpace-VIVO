#!/bin/bash 

###################################################################
# Script Name   :
# Description   :
# Args          : 
# Author       	: Michel Héon PhD
# Institution   : Université du Québec à Montréal
# Copyright     : Université du Québec à Montréal (c) 2022
# Email         : heon.michel@uqam.ca
###################################################################
export SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd -P)"
source $SCRIPT_DIR/../00-env.sh
DSPACE_URL=http://localhost:8081/server
#!/bin/bash
if which xdg-open > /dev/null
then
  xdg-open $DSPACE_URL
elif which gnome-open > /dev/null
then
  gnome-open $DSPACE_URL
fi

