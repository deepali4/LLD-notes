Requirements
 - Multiple levels - Floors
 - Different Type of Vehicles
 - Different Type of the spot( 2 wheeler , 4 Wheeler)
 - Strategy to find the cost
 - Multiple Gate and Exits
 - Functionality for finding the availability of the spot
 - Allocate sport upon entry and release it on exit gate


 ROUGH FLOW -

  vehicle - > entrance gate -> parking spot - > ticket -> exit (payment) - > out

Classes
LOT
EXIT gate
ENTRY  gate
FLOOR
SPOT
VEHICLE
TICKET
PAYMENT
enum type of vehicle
enum type of parking spot

Bottom UP

Vehicle
    - VehicleType type
    - LicencePlate

car extends vehicle
Truck extends vehicle
MotorCycle extend vehicle

parkedVehicle enum
{car , truck , motorCycle }

ParkingSpot
    - parkingSpotID
    - parkingSpotType
    - Vehicle parkedVehicle (HAS)
    methods
    -isAvailable()
    -parkVehicle()
    -unparkVehicle()
    -getparkingSpotType()
    -getparkedVehicle()

parkingSpotType enum
{  parkingSpotType,  TruckSpot , MotorCycleSpot }
CarSpot Extends ParkingSpot
TruckSpot Extends ParkingSpot
MotorCycleSpot Extends ParkingSpot



ParkingFloor
    - Map<parkingSpotType , Array<ParkingSpot>> ParkingSpot>
    - FloorId
    - DisplayBoard
  method
    - getListOfSpot()
    - getAvailableSpot(Vehicle)
    - getInUsedSpot()
    - getSpotForVehicle(VehicleType)

DisplayBoard -
    -displayMessage(parkingSpotType , number )


ParkingLot
    - Instance ParkingLot
    - ParkingFloor Array<ParkingFloor>
    - ParkVehicle
    - UnparkVehicle
    - EntryGates Array<EntryGate>
    - ExitGates Array<ExitGate>

EntryGate
  -id
  -generateTicket
  -getTicket(vehicle , floor ,spot )
ExitGate
  -id
  -calculateDuration
  -CalculatePrice

Ticket
  - id
  - Vehicle
  - ParkingSpotId
  - ParkingFloorId
  - Start
  - End
  - Amount




Steps
- create instance of the parking lot
- add level and add no of spot in that level
- instance .parkVehicle(vehicle) - iterate over the  parking level . then level iterate over the spot
   if spot is available add it to that spot

Design patterns can be used for LLD
-Singleton single instance of the parking lot
-Factory for creating the objects of the vehicle -     Vehicle car = VehicleFactory.createVehicle("car", "ABC123");
-Strategy to calculate the strategy of the payment hourly or flatRate
-Observer to update the display board


 - Concucerrency 
   public synchronized void parkVehicle(Vehicle vehicle)
   public synchronized void unparkVehicle() 
- ReentrantLock 
 - Concurrent Collections      private ConcurrentHashMap<Integer, String> parkingSpots = new ConcurrentHashMap<>();
 - private AtomicInteger availableSpots;




