# List Sum Calculator
my_list = [1,2,3,4,5]
s=0
print("The elements in the list are: "+str(my_list))
for l in my_list:
    s+=l
print("The sum of the numbers in the list is: "+str(s))

print("Now getting list from user:")
my_list2 = list(input("Enter the values in the list seperated by comma: ").split(","))
print("User input list is:"+str(my_list2))
#print(my_list2)
list_sum = 0
for element in my_list2:
    list_sum += int(element)

print("Sum of the elements in the list is: "+str(list_sum))
#print(list_sum)

