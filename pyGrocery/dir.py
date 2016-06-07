class A():
	"""
	This class show the usage of dir(). Use help(dir) for details.
	"""
	class_variable=1
	def __init__(self):
		self.init_instance_variable=1
		self.__priavate_init_instance_variable=1
	def print_dir(self):
		self.print_dir_instance_variable=1
		common_print_dir_variableh=1
		print(dir())

A().print_dir()
print "dir(A): %s"%dir(A)
print "dir(A()): %s"%dir(A())

