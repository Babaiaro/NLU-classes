import string

# PASTE the output from the Encryption script here:
cipher_txt = "M eq xgomrk GSS 320 xs wxyhc hexe irgvctxmsr" 
all_letters = string.ascii_letters
key = 4  # MUST match the key used in the Encryption program

# Dictionary and key substitution logic
dict2 = {}
for i in range(len(all_letters)):
    # Shift backwards to recover the original letter
    dict2[all_letters[i]] = all_letters[(i - key) % len(all_letters)]

# Loop to recover plain text
decrypt_txt = []

for char in cipher_txt:
    if char in all_letters:
        temp = dict2[char]
        decrypt_txt.append(temp)
    else:
        temp = char
        decrypt_txt.append(temp)

decrypt_txt = "".join(decrypt_txt)
print("Recovered plain text :", decrypt_txt)