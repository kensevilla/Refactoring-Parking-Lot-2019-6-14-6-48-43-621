SEVILKE refactor:
Remove ParkingBoyType. I realized that you can just use ParkingBoy as the parent of the other types of parking boy like smart and super smart parking boy. With this i just need to override the method chooseParkingLot() and the other behavior should be the same. 

SEVILKE refactor:
Refactor method fetch() of ParkingBoy. Use stream

SEVILKE refactor:
Remove unnecesarry if statement in the constructor in ParkingBoy

SEVILKE refactor:
Refactor method fetchCar() in ParkingLot

SEVILKE refactor:
Remove unused method - setParkingLotList() in ParkingBoy

SEVILKE refactor:
change access modifiers of fetchCar and parkCar to protected in ParkingLot

SEVILKE refactor:
refactor chooseParkingLot() of SmartParkingBoy and SuperSmartParkingBoy

