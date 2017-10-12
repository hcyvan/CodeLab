# Generator
def fab(m):
    n, a, b = 0, 0, 1
    while n < m:
        yield b
        a, b = b, a + b
        n += 1


# Iterator
class FabIter:
    def __init__(self, m):
        self.max = m
        self.n, self.a, self.b = 0, 0, 1

    def __iter__(self):
        return self

    def next(self):
        if self.n < self.max:
            self.a, self.b = self.b, self.a + self.b
            self.n += 1
            return self.a
        # raise StopIteration


# for i in FabIter(5):
#     print(i)

if __name__ == '__main__':
    print(fab(5))
    for i in fab(5):
        print(i)
