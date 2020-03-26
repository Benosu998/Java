public class Main {

    public static void main(String[] args) {
        Catalog catalog = new Catalog("D/graphs");
        catalog.add(new Graph("K4", "complete/k4.tgf", "complete/view/k4.png"));
        catalog.add(new Graph("Petersen", "special/petersen.tgf", "D:/ag/agr1.pdf"));
        catalog.list();
        //catalog.open("Petersen");
        catalog.save("catalog.ser");
        catalog.load("D/catalog.ser");

    }
}
