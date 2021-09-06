import os
import random

# Runs LSAVLApp and LSBSTApp
# Thomas Baloyi
# 15 April 2020

n = [298, 595, 893, 1190, 1488, 1786, 2083, 2380, 2678, 2976]
f = open("../data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt", "r")
data = f.readlines()
f.close()
subset = []

print("compiling java files")
os.system("javac *.java")
print("compiling done\n")

for i in range(10):
    print("current n value: " + str(n[i]))
    if (i==0):
        for j in range(n[i]):
            subset.append( (data[random.randint(0,2975)])[0:7].strip() )        
    elif (i==1):
        for j in range(n[i]):
            subset.append( (data[random.randint(0,2975)])[0:7].strip() )    
    elif (i==2):
        for j in range(n[i]):
            subset.append( (data[random.randint(0,2975)])[0:7].strip() )    
    elif (i==3):
        for j in range(n[i]):
            subset.append( (data[random.randint(0,2975)])[0:7].strip() )    
    elif (i==4):
        for j in range(n[i]):
            subset.append( (data[random.randint(0,2975)])[0:7].strip() )    
    elif (i==5):
        for j in range(n[i]):
            subset.append( (data[random.randint(0,2975)])[0:7].strip() )    
    elif (i==6):
        for j in range(n[i]):
            subset.append( (data[random.randint(0,2975)])[0:7].strip() )    
    elif (i==7):
        for j in range(n[i]):
            subset.append( (data[random.randint(0,2975)])[0:7].strip() )    
    elif (i==8):
        for j in range(n[i]):
            subset.append( (data[random.randint(0,2975)])[0:7].strip() )    
    elif (i==9):
        for j in range(n[i]):
            subset.append( (data[random.randint(0,2975)])[0:7].strip() )
    
    for p in range(n[i]):
        os.system("java LSBSTApp " + str(subset[p]) + " >> ../Test_Output/Part5/"+str(n[i])+"BST.txt")
        os.system("java LSAVLApp " + str(subset[p]) + " >> ../Test_Output/Part5/"+str(n[i])+"AVL.txt")
        
    subset.clear()       
    
print("removing class files")
os.system("rm *.class")
print("all work done")         