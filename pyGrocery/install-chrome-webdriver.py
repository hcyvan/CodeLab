#! /usr/bin/env python
import pexpect
import sys
TMP=r'/home/emc/browser_driver'
DRIVER=r'/usr/bin'
SUDO_PASSWORD=r'Password123!'

if len(sys.argv) >1 and sys.argv[1] == 'clean':
	# Uninstall chromedriver
	print(r'Removeing chromedriver ...')
	p=pexpect.spawn(r'sudo rm -f /usr/bin/chromedriver')
	index=p.expect([r'password',pexpect.EOF])
	print(r'chromedriver removed.')
	if index==0:
		p.sendline(SUDO_PASSWORD)
	# Uninstall google-chrome and depending libs
	print(r'Removeing google-chrome and depending libs ...')
	p=pexpect.spawn(r'sudo apt-get remove libxss1 libappindicator1 libindicator7')
	index=p.expect([r'password', r'Do you want to continue?', pexpect.EOF])
	if index==0:
		p.sendline(SUDO_PASSWORD)
		index=p.expect([r'Do you want to continue?', pexpect.EOF])
		if index==0:
			p.sendline('y\n')
		if index==1:
			print('google-chrome and depending libs is not installed!')	
	elif index==1:
		p.sendline('y\n')
	elif index==2:
		print('google-chrome and depending libs is not installed!')	

	exit()
	

# Download chromedriver and google_chrome
def download():
	print('********************************************************')
	print('Downloading chromedriver and google-chrome ...')
	ret=pexpect.run('mkdir -p %s'%TMP, withexitstatus=True)
	ret=pexpect.run(r'wget -P %s http://chromedriver.storage.googleapis.com/2.21/chromedriver_linux64.zip'%TMP,
			withexitstatus=True, timeout=3600)
	ret=pexpect.run(r'wget --no-check-certificate  -P %s https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb'%TMP,
			withexitstatus=True, timeout=3600)
	print('Download OK!')

# Install chromedriver to /usr/bin
def install_chromedriver():
	print('********************************************************')
	print('Installing chromedriver...')
	p=pexpect.spawn(r'sudo unzip -d %s %s/chromedriver_linux64.zip'%(DRIVER, TMP))
	index=p.expect([r'password',r'replace',pexpect.EOF])
	if index==0:
		p.sendline(SUDO_PASSWORD)
		
		index=p.expect([r'replace',pexpect.EOF])
		if index==0:
			print('Find chromedriver in %s and replace it.'%DRIVER)
			p.sendline('y\n')
			print('chromedriver is installed OK!')
		elif index==1:
			print('chromedriver is installed OK!')
	elif index==1:
		print('Find chromedriver in %s and replace it.'%DRIVER)
		p.sendline('y\n')
		print('chromedriver is installed OK!')
	elif index==2:
		print('chromedriver is installed OK!')
	index=p.expect(pexpect.EOF)  # This is to ensure the program is finished
	
	# Chagen the mode of chromedriver to make it executable.
	p=pexpect.spawn(r'sudo chmod 755 /usr/bin/chromedriver')
	index=p.expect(r'password')
	if index==0:
		p.sendline(SUDO_PASSWORD)

# Install google-chrome
def install_chrome():
	print('********************************************************')
	# Install depending packages
	p=pexpect.spawn(r'sudo apt-get install libxss1 libappindicator1 libindicator7')
	index=p.expect([r'password', pexpect.EOF])
	if index==0:
		p.sendline(SUDO_PASSWORD)
		print(r'Installing depending libs ...')
	elif index==1:
		print(r'Installing depending libs ...')

	index=p.expect([r'Do you want to continue?', pexpect.EOF])
	if index==0:
		p.sendline('y\n')
		print(r'Installing depending libs OK!')
	elif index==1:
		print(r'Installing depending libs OK!')
	index=p.expect(pexpect.EOF)  # This is to ensure the program is finished

	# Install chrome
	p=pexpect.spawn(r'sudo dpkg -i %s/google-chrome-stable_current_amd64.deb'%TMP)
	index=p.expect([r'password', pexpect.EOF])
	if index==0:
		p.sendline(SUDO_PASSWORD)
		print(r'Installing google-chrome ...')
	elif index==1:
		print(r'Installing google-chrome ...')

	index=p.expect(pexpect.EOF)  # This is to ensure the program is finished
	if index==0:
		print(r'Installing google-chrome OK!')

if not '-l' in sys.argv:
	download()
install_chromedriver()	
install_chrome()
