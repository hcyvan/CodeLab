import urllib.request
import re
import json
import time
import sys

def get_content(url):
	resp=urllib.request.urlopen(url)
	return resp.read().decode('utf-8')

def get_addr_by_ip(ip):
	url='http://ip.chinaz.com/%s'%ip
	html=get_content(url)
	items=re.compile('<span class="Whwtdhalf w50-0">(.*?)</span>')
	return items.findall(html)[-1]

def get_uid(rid):
	root="http://v.6.cn/%s"%rid
	html=get_content(root)
	puid_re=re.compile('puid: (\d+),')
	match=puid_re.search(html)
	if not match:
		sys.stderr.write("Can't find UID by RID %s\n"%rid)
		exit()
	return match.group(1)
def get_page(uid, page):
	url="http://v.6.cn/message/message_home_get.php?uid=%s&act=list&format=json&page=1&p=%s&start=0"%(uid, page)
	return json.loads(get_content(url))
def get_total_page_num(uid):
	j=get_page(uid,1)
	return j["content"]["pageCount"]

def get_ips(rid):
	uid=get_uid(rid)
	num=get_total_page_num(uid)
	tp=[]
	for i in range(num):
		items=get_page(uid, i+1)["content"]["content"]
		for item in items:
			ip=item.get('ip','')
			if ip:
				tp.append((item['tm'],ip))
	return tp

def print_detail(rid,times=True,ips=True, addrs=True):
	tps=get_ips(rid)
	ip_set=set([x[1] for x in tps])
	ip_dict={}
	for ip in ip_set:
		ip_dict[ip]=get_addr_by_ip(ip)
	for tp in tps:
		if times: 
			t=time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(tp[0]))
			sys.stdout.write('%s	'%t)
		if ips:
			sys.stdout.write('%s	'%tp[1])
		if addrs:
			sys.stdout.write('%s'%ip_dict[tp[1]])
		sys.stdout.write('\n')

if len(sys.argv)==1:
	sys.stderr.write('RID needed\n');
	exit()
rid=sys.argv[1]
print_detail(rid, ips=False)
