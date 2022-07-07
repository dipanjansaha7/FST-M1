#Recursive Adder

# Define function to calculate sum
def calculateSum(num):
  if num:
    # Recursive function call
    return num + calculateSum(num-1)
  else:
    return 0

# Call calculateSum() function
user_input = int(input("Key in a number: "))
res = calculateSum(user_input)

# Print result
print("The sum is: " + str(res))