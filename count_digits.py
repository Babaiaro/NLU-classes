def count_digits(n):
    # Base case: if n is single digit, return 1
    if n < 10:
        return 1
    # Recursive step: 1 + count of digits in n/10
    else:
        return 1 + count_digits(n // 10)

# Testing with required values
print(f"Digits in 15: {count_digits(15)}")
print(f"Digits in 105: {count_digits(105)}")
print(f"Digits in 15105: {count_digits(15105)}")