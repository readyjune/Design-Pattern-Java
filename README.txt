README
======

This is a Gradle project structure, so you can get started on the assignment without messing around with Gradle too much.

Basically: 
* Put all your source code in src/main/java (or in further subdirectories inside src/main/java).
* Type "./gradlew run" to run. 
* Type "./gradlew check" to verify PMD rules. (On Windows, drop the "./" from start of course; i.e., "gradlew run" or "gradlew check".)
* Gradle currently considers "edu.curtin.app.App" to be the name (and package) of the main class. If you change this, you must also edit build.gradle, and change the "mainClass = ..." line accordingly.


---  How to use application ---

Brief explanation about this program.

When user type ./gradlew run,  program will be started.

When program is running, the message below will be coming out.


 - Program is started - 
 This program has a default objects 
 Passenger Object - 'Josh' and 'Mary'
 Vehicle Object - 'Train' and 'Bus'


As it mentioned, there are default objects in this program as soon as program is started.
Because this assignment is mainly showing design pattern and not focusing on fancy implementation or functionality.

And This application has a 2 menu options.

First option menu is selecting a passenger's object "Josh" or "Mary" otherwise user can terminate the program by entering 3.
 

Choose the name for Passenger Object from 1 -2 or 3 terminate the program
 1. Josh
 2. Mary
 3. End

Second option menu is playing around with selected user.

Select the menu
1. Passenger Detail
2. Get on the bus
3. Get on the train
4. Get off the bus
5. Get off the train
6. Recharge Saving

Select 1 -> This will show the passenger detail.

Passenger Details
Name: Josh
Account Saving: 7
Account Status: Good Standing
Account onBoard: false
Entry Time: null
Exit Time: null
Vehicle Kind: null


Select 2 to 5 -> Passenger can get on or off the vehicle(Train or Bus). 
With the displaying the sentences of ("josh" is on board now")

Select 6 -> Passenger needs a money to get on the vehicle. And depend on the money passenger has, it will affect on passenger accountStatus( 1. GoodStanding, 2. InDebt or 3. Cancelled). So Passenger is able to recharge accountSaving.

If accountSaving is >= 5, then accountStatus will be Good Standing.

If accountSaving is < 5 and and accountSaving is >= 0, then accountStatus will be InDebt.

If accountSaving is < 0, then accountStatus will be Cancelled.



All the code has an error handling and logging.


Observer Pattern has been used for checking passenger's accountStatus when passenger's accountSaving is changed and then notify to user.

State Pattern has been used for checking passenger's accountStatus depend on passenger's accountSaving and it has a 3 status ("Good Standing", "In Debt" and "Cancelled").

Factory Pattern has been used for creating on vehicle object with "Bus" and "Train".
This can be implemented for creating an object for Passenger in the future.
But in this assignment, it is enough to show about creating an Vehicle object.

Dependency Injection has been used for swiping card when passenger rides a vehicle.


