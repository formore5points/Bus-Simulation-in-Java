# Bus-Simulation-in-Java
OOP Based Bus Simulation using Java and Enigma
# Project:  Big City 

The aim of the project is to develop an application which simulates 
the bus lines, buses and passengers in a big city.

# General Information

The application simulates a 21*57-square city which consists of building blocks, roads and bus stops. While the buses move on the lines, passengers get on and off. The aim of the application is to simulate the public transport system of the city and create statistics.

# Simulation Elements

# Bus Stops

•	There are 16 bus stops in the simulation. Letters A-P represent the bus stops.
•	The number at the bottom right square of the bus stop shows the number of the waiting passengers. 

# Bus Lines

There are 6 bus lines. Each line has several bus stops. Lines are named according to the first bus stop of the line. 

Line A:  A-E-I-J-K-L

Line B:  B-F-E-I-J-N-M

Line C:  C-G-K-J-F-E-A

Line D:  D-C-G-K-J-N-M

Line L:  L-P-O-K-G-C-D-H

Line M:  M-N-J-F-G-K-O-P


•	Consecutive bus stops on a line are horizontally or vertically aligned.
•	Each line has 2 buses. At the beginning, buses of the line start at the both endpoints of the line. When a bus reaches to the other endpoint, it starts from there. 
•	Buses of the line are named according to the line name and number. (As an example, Line A busses: A1, A2)

![1](https://user-images.githubusercontent.com/50989796/125788546-ef6367f8-df01-499f-8c9c-e4906793400a.png)

# Buses

•	The capacity of a bus is 8 passengers. Also each bus has a luggage department for 8 pieces of luggage. Access to a luggage is limited to one door and passage way.
•	Each luggage-put-or-take operation takes 1 unit time. Passengers' getting on or getting off operations take no time.
•	Buses move 1 square in 2 unit-time while they move.
•	Buses are represented by the number of passengers they carry. 

# Passengers

•	Each passenger has a unique integer ID.
•	Passengers are generated randomly and put in a queue (random line, random from-to bus stops and random time of entering simulation). The queue has 15 elements and it is always full. The passengers in the queue are represented by the inital bus stops. In the queue, each passenger waits for a time span (0 or 1 unit-time randomly) after the previous passenger.
•	When a passenger enters the system/simulation, he/she waits for his/her bus at the initial bus stop. If there is enough space for a passenger and his/her luggage, he/she gets on the bus. When the passenger comes to the final bus stop of his/her journey, he/she gets off the bus and disappears off the system.

# Luggage

•	Each luggage has a unique integer ID in the simulation.
•	Each passenger has 0-2 (random) pieces of luggage.   

# Simulation Time and User interface

•	The time in this simulation starts in pause mode. 1 unit time is 0.5 or 1 second in real life.
•	The bus or the bus stop with the cursor on will be listed on the right of the screen with its passengers and their luggage. 

# Keys:
'R' key        :   paused simulation -> running simulation

Space key   :   running simulation -> paused simulation

Space key   :   paused simulation -> paused simulation (simulation runs for 1 unit-time with each press)

![2](https://user-images.githubusercontent.com/50989796/125788487-0accdfae-ceb3-434e-8b8a-3f2273d047b4.png)
