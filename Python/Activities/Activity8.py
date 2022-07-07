#List Checker
my_list = list(input("Enter the elements seperated by comma: ").split(","))
if (my_list[0] == my_list[-1]):
    print("The first and the last element of the list are equal, which is "+str(my_list[0]))
else:
    print("The first and the last element of the list are NOT equal, which are "+str(my_list[0])+" and "+str(my_list[-1]))

