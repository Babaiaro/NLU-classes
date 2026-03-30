
import string

# Setup
all_letters = string.ascii_letters

# Part 1 - Encryption Steps
# 1. Original plaintext message (Minimum 10 words)
original_plaintext = "I am learning how to apply multiple layers of data encryption"
print("--- ENCRYPTION PROCESS ---")
print(f"Original Plaintext: {original_plaintext}\n")

# Define 5 different keys for the 5 levels
keys = [3, 7, 12, 5, 9]
current_message = original_plaintext

# Sequential Encryption Loop
for i, key in enumerate(keys, 1):
    # Create encryption dictionary for this level
    enc_dict = {}
    for j in range(len(all_letters)):
        enc_dict[all_letters[j]] = all_letters[(j + key) % len(all_letters)]
    
    # Apply encryption to the current version of the message
    temp_cipher = []
    for char in current_message:
        if char in all_letters:
            temp_cipher.append(enc_dict[char])
        else:
            temp_cipher.append(char)
    
    current_message = "".join(temp_cipher)
    
    # Document each level
    print(f"Level {i} Encryption (Caesar Cipher, Key: {key})")
    print(f"Intermediate Ciphertext: {current_message}\n")

final_ciphertext = current_message
print(f"FINAL CIPHERTEXT: {final_ciphertext}")
print("-" * 30 + "\n")


# Part 2 - Decryption Steps
print("--- DECRYPTION PROCESS ---")
print(f"Starting with Final Ciphertext: {final_ciphertext}\n")

# To decrypt, we must reverse the keys and the order (Level 5 down to Level 1)
decryption_keys = keys[::-1] 
current_decryption = final_ciphertext

for i, key in enumerate(decryption_keys, 1):
    # Create decryption dictionary (Reverse shift)
    dec_dict = {}
    for j in range(len(all_letters)):
        dec_dict[all_letters[j]] = all_letters[(j - key) % len(all_letters)]
        
    # Apply decryption
    temp_plain = []
    for char in current_decryption:
        if char in all_letters:
            temp_plain.append(dec_dict[char])
        else:
            temp_plain.append(char)
            
    current_decryption = "".join(temp_plain)
    
    # Document each level (Showing the reverse steps)
    actual_level = 6 - i # Tracks which original level is being undone
    print(f"Undoing Level {actual_level} (Caesar Cipher, Key: {key})")
    print(f"Intermediate Message: {current_decryption}\n")

print(f"FINAL DECRYPTED PLAINTEXT: {current_decryption}")