#include <string>
#include <iostream>
using namespace std;
bool isAnagrams(string a, string b)
{
	int la=a.length(), lb=b.length();
	if(la!=lb)
		return false;

	int* map=new int[256]();
	for(int i=0;i<la;i++)
		map[a[i]]++;
	for(int i=0;i<lb;i++)
		map[b[i]]--;
	for(int i=0;i<256;i++)
		if(map[i]!=0)
			return false;
	return true;
}
void test(string a, string b)
{
	if(isAnagrams(a,b))
		cout<<"equal"<<endl;
	else
		cout<<"not equal"<<endl;
}
int main()
{
	string a="cheng";
	string b="ghcne";
	string c="ccheg";
	test(a,b);
	test(a,c);
	
	return 0;
}
