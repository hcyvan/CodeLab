print "############### generator ############"
def fab(max):
    n, a, b = 0, 0, 1
    while n < max:
        yield b
        a, b = b, a+b
        n+=1

for i in fab(5):
    print i

print "############### iterator #############"
class fab_iter(object):
    def __init__(self, max):
        self.max = max
        self.n, self.a, self.b = 0, 0, 1
    
    def __iter__(self):
        return self
    
    def next(self):
        if self.n < self.max:
            self.a, self.b = self.b, self.a + self.b
            self.n += 1
            return self.a
        raise StopIteration
    
for i in fab_iter(5):
    print i    