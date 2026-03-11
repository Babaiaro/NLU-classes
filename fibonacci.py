def fibonacci(n):
    if n <= 1:
        return n
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)

# Asking for user input
num = int(input("Which Fibonacci number do you want to find? "))
print(f"The {num}th Fibonacci number is: {fibonacci(num)}")