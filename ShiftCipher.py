import string

# A list containing all characters: abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
all_letters = string.ascii_letters

dict1 = {}
key = 4  # CHANGE THIS for your second test (e.g., to 10)

# Create a dictionary to store the substitution for the plain text based on the key
for i in range(len(all_letters)):
    dict1[all_letters[i]] = all_letters[(i + key) % len(all_letters)]

message = "I am taking CSS 320 to study data encryption"
cipher_txt = []

# Loop to generate ciphertext
for char in message:
    if char in all_letters:
        temp = dict1[char]
        cipher_txt.append(temp)
    else:
        temp = char
        cipher_txt.append(temp)

cipher_txt = "".join(cipher_txt)
print("Cipher Text is: ", cipher_txt)