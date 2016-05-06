#===============================================================================
# Instance variable is more common than class variable.
#===============================================================================

class TestData():
    class_var=1                 # This is a class variable
    def __init__(self):
        self.instance_var=2     # This is a instance variable
        
    def get_instance_var(self):
        return self.instance_var
    @classmethod
    def get_class_var(cls):
        return cls.class_var

print(TestData().get_instance_var()) # TestData is instantiated
print(TestData.get_class_var())      # TestData is not instantiated  

