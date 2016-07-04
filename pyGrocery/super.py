class LogDict(dict):
    def __setitem__(self, key, value):
        print "Setting %s to %s"%(key, value)
        # super().__setitem__(key, value) in python3
        super(LogDict, self).__setitem__(key, value)

mydict=LogDict()
mydict['a']=1
print mydict

