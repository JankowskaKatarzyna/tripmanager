package pl.edu.agh.mwo;

public class Demo {
    public static void main(String[] args) throws TripAlreadyExistsException {
        Trip trip1 = new Trip("Kuba", "Hawana");
        Trip trip2 = new Trip("Jamaica", "Hawana");
        Trip trip3 = new Trip("Francja", "Jamaica");
        Trip trip4 = new Trip("Hawana", "Włochy");
        TripManager tripManager = new TripManager();
        tripManager.add(trip1);
        tripManager.add(trip2);
        tripManager.add(trip3);
        tripManager.add(trip4);
        System.out.println(tripManager.findTrip("Hawana").getName());


    }
}
