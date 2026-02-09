# Modified Linear Search
def search(arr, n, x):
    iterations = 0 # Track iterations
    for i in range(0, n):
        iterations += 1
        if (arr[i] == x):
            return i, iterations # Return both index and count
    return -1, iterations

# Modified for User Input
user_input = input("Enter numbers separated by spaces: ")
arr = [int(i) for i in user_input.split()]
x = int(input("Enter the search item: "))
n = len(arr)

# Function call
result, count = search(arr, n, x)

if(result == -1):
    print(f"Element is not present in array. Iterations: {count}")
else:
    print(f"Element is present at index {result}. Iterations: {count}")