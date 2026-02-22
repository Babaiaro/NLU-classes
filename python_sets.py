# 1. Create an empty set and a non-empty set

x = set()  # empty set
n = {0, 1, 2, 3, 4}  # non-empty set

print("Empty set x:", x)
print("Non-empty set n:", n)

# 2. Add elements to a set

colors = set()  # start with empty set

colors.add("Red")  # add single element
colors.update(["Blue", "Green"])  # add multiple elements

print("Updated colors set:", colors)

# 3. Create intersection of two sets

x = {"green", "blue"}
y = {"blue", "yellow"}

intersection = x.intersection(y)

print("Intersection of x and y:", intersection)

# 4. Create union of two sets

x = {"green", "blue"}
y = {"blue", "yellow"}

union = x.union(y)

print("Union of x and y:", union)

# 5. Create set difference

x = {"apple", "mango"}
y = {"mango", "orange"}

difference = x.difference(y)

print("Difference of x and y (x - y):", difference)

# 6. Check if one set is subset of another

x = {"apple", "mango"}
y = {"mango", "orange"}
z = {"mango"}

print("Is z a subset of x?", z.issubset(x))
print("Is z a subset of y?", z.issubset(y))

# 7. Check if sets have no elements in common

x = {1, 2, 3, 4}
y = {4, 5, 6, 7}
z = {8}

print("Are x and y disjoint?", x.isdisjoint(y))
print("Are x and z disjoint?", x.isdisjoint(z))