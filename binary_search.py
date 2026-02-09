# Modified Binary Search
def binarySearch(arr, l, r, x): 
    iterations = 0 # Track iterations
    while l <= r: 
        iterations += 1
        mid = l + (r - l) // 2
          
        if arr[mid] == x: 
            return mid, iterations
        elif arr[mid] < x: 
            l = mid + 1
        else: 
            r = mid - 1
      
    return -1, iterations

# Modified for User Input
user_input = input("Enter numbers separated by spaces (MUST BE SORTED): ")
arr = [int(i) for i in user_input.split()]
x = int(input("Enter the search item: "))

# Function call 
result, count = binarySearch(arr, 0, len(arr)-1, x) 

if result != -1: 
    print(f"Element is present at index {result}. Iterations: {count}")
else: 
    print(f"Element is not present in array. Iterations: {count}")