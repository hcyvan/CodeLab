print'********* Without Argument ************'
def tsfun(func):
    def wrappedFunc():
        print '%s is called'%func.__name__
        return func
    
    return wrappedFunc

@tsfun
def foo():
    pass

foo()

print '************* With Argument *******************'

def tsfun_arg(arg):
    def tsunc(func):
        def wrappedFunc():
            print arg 
            return func
        return wrappedFunc
    return tsunc 

@tsfun_arg('This is tsfunc_arg decorator')
def bar():
    pass
bar()