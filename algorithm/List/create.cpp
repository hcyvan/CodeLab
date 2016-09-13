#include <iostream>
#include <stdlib.h>
using namespace std;
typedef struct Node{
	int data;
	struct Node *next;
} node;
node* create_list()
{	
	int data;
	node* tmp;
	node* head=(node*)malloc(sizeof(node));
	head->next=NULL;
	node* p=head;
	while(cin >> data){
		p->next=(node*)malloc(sizeof(node));	
		p=p->next;
		p->data=data;
		p->next=NULL;
	}
	cin.clear();
	tmp=head;
	head=head->next;
	delete tmp;
	return head;
}
int length(node *head)
{
	int n=0;
	while(head){
		n++;
		head=head->next;
	}
	return n;
}
void print(node *head)
{
	cout << "\nThe Link List: ";
	while(head){
		cout<<head->data<<" ";
		head=head->next;
	}
	cout << endl;
}
void del(node *&head)
{
	int num=0;
	node *p, *p0;
	print(head);
	cout << "which number Do you want to delete: ";
	cin >> num;
	cin.clear();
	p=head;
	while(num!=p->data && p->next){
		p0=p;
		p=p->next;
	}
	if(num==p->data){
		if(p==head)
			head=p->next;
		else
			p0->next=p->next;
		p->next=NULL;
		delete p;
		cout << "Delete "<<num;
		print(head);
	}else
		cout<< "Can't find "<<num<<" in the list" << endl;
}	
void insert_before_big(node *&head)
{
	int num=0;
	node *p, *p0, *pn;
	print(head);
	cout << "which number Do you want to insert: ";
	cin >> num;
	cin.clear();
	pn=(node*)malloc(sizeof(node));
	pn->data=num;
	pn->next=NULL;
	p=head;

	while(num>p->data && p->next){
		p0=p;
		p=p->next;
	}
	if(num <= p->data){
		if(p==head){
			head=pn;
			pn->next=p;
		}else{
			p0->next=pn;
			pn->next=p;	
		}
	}else{
		p->next=pn;
	}		
	cout << "The inserted list is: ";
	print(head);
}
	
int main()
{
	node *head=create_list();
	insert_before_big(head);
	del(head);
	print(head);
	return 0;
}
	
