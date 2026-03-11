def sum(x):
    # Base case: if x is 1, the sum is 1
    if x == 1:
        return 1
    # Recursive step: add current x to the sum of (x-1)
    else:
        return x + sum(x - 1)

print(sum(10))