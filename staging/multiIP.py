from httplib import *
import threading
import time

def multIpTest(source_ip):
	http=HTTPConnection("www.fudan.edu.cn",source_address=(source_ip,44302))
	http.request("GET","/2016/channels/view/34/")
	print http.getresponse().getheaders()
	print
	time.sleep(1000)
	

'''
http1=HTTPConnection("www.fudan.edu.cn",source_address=('192.168.1.105',44302))
http1.request("GET","/2016/channels/view/34/")
print http1.getresponse().getheaders()

http1=HTTPConnection("www.fudan.edu.cn",source_address=('192.168.1.104',44301))
http1.request("GET","/2016/channels/view/34/")
print http1.getresponse().getheaders()
'''
t1 = threading.Thread(target=multIpTest, args=('192.168.1.105',))
t2 = threading.Thread(target=multIpTest, args=('192.168.1.104',))
t1.start()
t2.start()
t1.join()
t2.join()
print "test over"

