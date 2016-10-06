from selenium import webdriver
import time
import json
import os

WAIT=30
'''
COOKIES=[{'domain': '.baidu.com', 'name': 'BAIDUID', 'value': 'CB58BA81914DE58B5C5D8DA5D09E3F65:FG=1', 'expiry': 1507178934, 'path': '/', 'httpOnly': False, 'secure': False}, {'domain': 'index.baidu.com', 'name': 'searchtips', 'value': '1', 'expiry': 1506746934, 'path': '/', 'httpOnly': False, 'secure': False}, {'domain': '.baidu.com', 'name': 'BDUSS', 'value': 'jBqLTVibDhRM3BPMFdFa3FTbHRBTEFlcVdxUjY4enRlWDNBLU01dWRWMUVFeHhZQVFBQUFBJCQAAAAAAAAAAAEAAADLPtRkAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAESG9FdEhvRXa', 'expiry': 1734842948, 'path': '/', 'httpOnly': True, 'secure': False}, {'domain': 'index.baidu.com', 'name': 'CHKFORREG', 'value': '00b3f5ca4276a5506559646534478944', 'expiry': 1475729349, 'path': '/', 'httpOnly': False, 'secure': False}, {'domain': '.index.baidu.com', 'name': 'Hm_lvt_d101ea4d2a5c67dab98251f0b5de24dc', 'value': '1475642935', 'expiry': 1507178950, 'path': '/', 'httpOnly': False, 'secure': False}, {'domain': '.index.baidu.com', 'name': 'Hm_lpvt_d101ea4d2a5c67dab98251f0b5de24dc', 'value': '1475642950', 'expiry': None, 'path': '/', 'httpOnly': False, 'secure': False}]
EXCEPT_COOKIES_NAME=['Hm_lvt_d101ea4d2a5c67dab98251f0b5de24dc','Hm_lpvt_d101ea4d2a5c67dab98251f0b5de24dc']
'''
COOKIES_FILE='./baidu_login_cookies'
EXCEPT_COOKIES_NAME=['Hm_lvt_d101ea4d2a5c67dab98251f0b5de24dc','Hm_lpvt_d101ea4d2a5c67dab98251f0b5de24dc']

def print_cookies(cookies):
	for c in cookies:
		print('-'*20)
		for k,v in c.iteritems():
			print("%s %s"%(k,v))
	
def get_cookies():
	'''
		在selenium中手工输入验证码后，获得cookies，将cookies存放在同目录
		下 baidu_login_cookies 中。
	'''
	browser=webdriver.Firefox()
	browser.get('http://index.baidu.com/?tpl=trend&word=')
	#cookies=browser.get_cookies()
	browser.find_element_by_id("TANGRAM_12__userName").send_keys("18817583485")
	browser.find_element_by_id("TANGRAM_12__password").send_keys("c176431")
	browser.find_element_by_id("TANGRAM_12__submit").click()

	print('Waiting %s for inputing verification code ...'%WAIT)
	time.sleep(WAIT)
	cookies=browser.get_cookies()
	browser.quit()
	with open(COOKIES_FILE,'w') as f:
		json.dump(cookies, f)
	return cookies

class Spider():
	def __init__(self,cookies,wait_time=30):
		self.browser=webdriver.Firefox()
		self.browser.maximize_window()
		self.browser.implicitly_wait(wait_time)
		self.browser.get('http://index.baidu.com/?tpl=trend&word=')
		#browser.delete_all_cookies()
		for cookie in cookies:
			if cookie['name'] not in EXCEPT_COOKIES_NAME:
				self.browser.add_cookie(cookie)
		self.browser.get('http://index.baidu.com/?tpl=trend&word=')
		self.browser.find_element_by_id("schword2").send_keys('init')
		self.browser.find_element_by_id("schsubmit").click()

	def find_key_word(self,word):
		schword=self.browser.find_element_by_id("schword")
		schword.clear()
		schword.send_keys(word)
		self.browser.find_element_by_id("schsubmit").click()

	def get_index_point(self):
		return self.bezier_filter(self.get_index_curve7())

	def get_index_curve7(self):
		t=0.5
		js="return $(\"path[fill='none'][stroke-opacity='1']\").attr('d')"
		data=None
		while((not data) and t<20):
			time.sleep(t)
			data=self.browser.execute_script(js)
			t=t*2
		return data
	def bezier_filter(self,data):
		'''
		M1,2C1,2,3,4,5,6C1,2,3,4,5,6 ... C1,2,3,4,5,6C1,2,3,4
		'''
		points=[]
		for i in data[1:].split('C'):
			ps=i.split(',')[-2:]
			points.append((float(ps[0]),float(ps[1])))
		return points
	#def get_two_points():
		
if __name__=='__main__':
	cookies=''
	if os.path.exists(COOKIES_FILE):
		with open(COOKIES_FILE) as f:
			cookies=json.load(f)
	else:
		cookies=get_cookies()

	spider=Spider(cookies,wait_time=10)
	spider.find_key_word('复旦')
	p=spider.get_index_point()
	print(p)
	#spider.find_key_word('cba')
