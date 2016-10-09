#include <iostream>

class Vertex
{
	int 

template<class T>
class Graph
{
public:
	virtual ~graph(){}

	virtual int numberOfVertices() const=0;
	virtual int numberOfEdges() const=0;
	virtual bool existsEdge(int, int)=0;
	virtual void insertEdge(int, int)=0;
	virtual void eraseEdge(int, int)=0;
	
	virtual bool isDirected() const=0;
	virtual bool isWeighted() const=0;
	
};
	
