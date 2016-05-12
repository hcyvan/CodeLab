#####################################################################
# This is a Bash script for install google-chrome and chromedriver.
# You should download the file and execute it.
#
# Usage: sudo bash ./install_chrome_webdriver.sh 
#
# /home/emc/browser_driver could be removed if you don't want the
# packages. Contact me if there is any bug.
#
# By: Navy Cheng
# Time: 2016.5.12
#####################################################################
DOWNLOAD=/home/emc/browser_driver
mkdir -p ${DOWNLOAD}
cd ${DOWNLOAD}

wget http://chromedriver.storage.googleapis.com/2.21/chromedriver_linux64.zip
if [[ $? -ne 0 ]];then
    echo -e "\n*** chromedriver_linux64.zip download failed!"
    exit
fi
unzip chromedriver_linux64.zip
if [ -f chromedriver ];then
    mv chromedriver /usr/bin/chromedriver
    chmod 755 /usr/bin/chromedriver
    echo -e "\n Install chromedirver to /usr/bin successfully."
else
    echo -e "\n*** Can't find chromedriver!"
    exit
fi
wget --no-check-certificate  https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
if [[ $? -ne 0 ]];then
    echo -e "\n*** google-chrome-stable_current_amd64.deb download failed!"
    exit
fi

apt-get install libxss1 libappindicator1 libindicator7
dpkg -i google-chrome*.deb
if [[ $? -eq 0 ]];then
    echo -e "\n Install google-chrome successfully."
fi
