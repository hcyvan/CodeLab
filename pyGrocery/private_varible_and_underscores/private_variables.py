- "Private" instance variables that cannot be accessed except from inside an
object donnot exist in Python. 
- Single leading underscore have two kinds of uses:
  - eg: from M import * do not import the objects with a leading-single
        underscore. However, you can acess the objects use M.objects.
  - Just to indicate other programmers that the objects is intended to be
    'private'. However, nothing special is done with the name itself.
- Double leading underscores use *name mangling* to avoid name clashes.
  eg: Any identifier of form __spam is textually replaced with
  _classname__spam, where classname is the current class name with leading
  single underscore:
  - You cannot access classname.__spam directly. You should use
    classname._classname__spam instead. This is make __spam looks like a
    'Private' variable. __spam is more private than _spam.
  - A private method will not be override by its subclass-method.
    eg: classname.__spam() will not be override if you defined a
    subclassname.__spam()
# from module import *
import module
class a():
    def __init__(self):
        self.__var1=1
        self.var2=2
    def get_var1(self):
        return self.__var1
    def get_var2(self):
        return self.var2
    
inst_a=a()
# print(inst_a.__var1)
print(inst_a._a__var1)
print(inst_a.get_var1())
print(inst_a.var2)

print('****************************')
print(module_private._var1)
pub_class_inst=module_private.pub_class()
pub_class_inst._private_fun()
